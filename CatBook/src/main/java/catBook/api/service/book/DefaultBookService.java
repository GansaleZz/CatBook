package catBook.api.service.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.api.transformer.book.container.BookParametersContainer;
import catBook.main.bean.book.Book;
import catBook.main.hibernate.criteria.book.BookHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookService extends GenesisCreateService<BookResponseDTO, Book, BookRequestDTO> implements BookService {

    @Override
    public CollectionModel<EntityModel<BookResponseDTO>> findAll(PageFilter pageFilter, BookParametersContainer container) {
        BookHibernateQueryCriteria criteria = new BookHibernateQueryCriteria();

        if (container.getBookName() != null) {
            criteria.setBookName(container.getBookName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }

    @Override
    protected Book doSave(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setBookName(bookRequestDTO.getBookName());

        return manager.save(book);
    }
}
