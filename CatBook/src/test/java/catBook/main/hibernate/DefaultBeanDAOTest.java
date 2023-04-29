package catBook.main.hibernate;

import catBook.main.bean.Book;
import catBook.main.hibernate.DAO.book.DefaultBookDAO;
import catBook.config.TestHibernateConfig;
import catBook.main.hibernate.DAO.book.DefaultBookTypeDAO;
import catBook.main.hibernate.criteria.book.BookHibernateQueryCriteria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This tests covers hibernate DAO layer. P.S. using only {@link DefaultBookDAO} for tests, because it's very enough to
 * cover all existing logic, and if it works for {@link DefaultBookDAO}, then it will be worked for each existing Beans.
 *
 * @author GansaleZz
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestHibernateConfig.class }, loader = AnnotationConfigContextLoader.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application.properties")
@Sql(scripts = "classpath:/db-init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DefaultBeanDAOTest {

    @Autowired
    protected DefaultBookDAO defaultBookDAO;

    @Autowired
    protected DefaultBookTypeDAO defaultBookTypeDAO;

    @Test
    public void testFindAll_withoutCriteria() {
        //Method Call
        List<Book> result = defaultBookDAO.findAll();

        //Assert&Verify
        assertEquals(5, result.size());
    }

    @Test
    public void testFindAll_withCriteria_resultExists() {
        //Setup
        String bookName = "TEST1";
        long bookTypeID = 1;
        long bookID = 1;
        BookHibernateQueryCriteria criteria = new BookHibernateQueryCriteria();
        criteria.setID(bookID);
        criteria.setBookTypeID(bookTypeID);
        criteria.setBookName(bookName);
        criteria.setActive(true);

        //Method Call
        List<Book> result = defaultBookDAO.findAll(criteria);

        //Assert&Verify
        assertEquals(1, result.size());
        assertEquals(bookID, result.get(0).getID());
        assertEquals(bookName, result.get(0).getBookName());
        assertEquals(bookTypeID, result.get(0).getBookType().getID());
        assertTrue(result.get(0).isActive());
    }

    @Test
    public void testFindAll_withCriteria_resultNotExists() {
        //Setup
        String bookName = "TEST1";
        long bookTypeID = 1;
        long bookID = 1;
        BookHibernateQueryCriteria criteria = new BookHibernateQueryCriteria();
        criteria.setID(bookID);
        criteria.setBookTypeID(bookTypeID);
        criteria.setBookName(bookName);
        criteria.setActive(false);

        //Method Call
        List<Book> result = defaultBookDAO.findAll(criteria);

        //Assert&Verify
        assertEquals(0, result.size());
    }

    @Test
    public void testFindAll_paging() {
        //Setup
        Pageable pageable = PageRequest.of(2, 1);
        long expectedBookID = 3;

        //Method Call
        List<Book> result = defaultBookDAO.findAll(pageable);

        //Assert&Verify
        assertEquals(1, result.size());
        assertEquals(expectedBookID, result.get(0).getID());
    }

    @Test
    public void testFindAll_sorting() {
        //Setup
        Sort sort = Sort.by(Sort.Direction.DESC, "ID");
        long expectedBookID = 5;

        //Method Call
        List<Book> result = defaultBookDAO.findAll(sort);

        //Assert&Verify
        assertEquals(5, result.size());
        assertEquals(expectedBookID, result.get(0).getID());
    }

    @Test
    public void testFindAll_sortingAndPaging() {
        //Setup
        Sort sort = Sort.by(Sort.Direction.DESC, "bookName");
        Pageable pageable = PageRequest.of(3, 1, sort);
        long expectedBookID = 2;

        //Method Call
        List<Book> result = defaultBookDAO.findAll(pageable);

        //Assert&Verify
        assertEquals(1, result.size());
        assertEquals(expectedBookID, result.get(0).getID());
    }

    @Test
    public void testFindAll_withCriteria_sortingAndPaging() {
        //Setup
        Sort sort = Sort.by(Sort.Direction.DESC, "ID");
        Pageable pageable = PageRequest.of(0, 1, sort);
        long expectedBookID = 4;
        BookHibernateQueryCriteria criteria = new BookHibernateQueryCriteria();
        criteria.setActive(false);

        //Method Call
        List<Book> result = defaultBookDAO.findAll(pageable, criteria);

        //Assert&Verify
        assertEquals(1, result.size());
        assertEquals(expectedBookID, result.get(0).getID());
    }

    @Test
    public void testFindByID_exists() {
        //Setup
        long bookID = 3;

        //Method Call
        Book result = defaultBookDAO.findByID(bookID);

        //Assert&Verify
        assertNotNull(result);
        assertEquals(bookID, result.getID());
    }

    @Test
    public void testFindByID_notExists() {
        //Method Call
        Book result = defaultBookDAO.findByID(6);

        //Assert&Verify
        assertNull(result);
    }

    @Test
    public void testSave_success() {
        //Setup
        long expectedBookID = 6;
        long bookTypeID = 3;
        String bookName = "TEST6";

        Book newBook = new Book();
        newBook.setBookType(defaultBookTypeDAO.findByID(bookTypeID));
        newBook.setBookName(bookName);

        //Method Call
        Book result = defaultBookDAO.save(newBook);

        //Assert&Verify
        assertNotNull(result);
        assertEquals(expectedBookID, result.getID());
        assertEquals(bookTypeID, result.getBookType().getID());
        assertEquals(bookName, result.getBookName());
    }

    @Test()
    public void testSave_failed_emptyBookName() {
        //Setup
        long bookTypeID = 1;
        Book newBook = new Book();
        newBook.setBookType(defaultBookTypeDAO.findByID(bookTypeID));

        //Method Call
        RuntimeException result = assertThrows(RuntimeException.class, () -> {
            defaultBookDAO.save(newBook);
        });

        //Assert&Verify
        assertNotNull(result);
    }

    @Test
    public void testRemove() {
        //Setup
        long bookID = 1;
        Book book = defaultBookDAO.findByID(bookID);

        //Method Call
        Book result = defaultBookDAO.remove(book);

        //Assert&Verify
        assertFalse(result.isActive());
    }

    @Test
    public void testDelete() {
        //Setup
        long bookID = 1;

        //Method Call
        defaultBookDAO.delete(bookID);
        Book book = defaultBookDAO.findByID(bookID);

        //Assert&Verify
        assertNull(book);
    }

    @Test
    public void testCount() {
        //Setup
        long expectedCount = 5;

        //Method Call
        long result = defaultBookDAO.count();

        //Assert&Verify
        assertEquals(expectedCount, result);
    }
}
