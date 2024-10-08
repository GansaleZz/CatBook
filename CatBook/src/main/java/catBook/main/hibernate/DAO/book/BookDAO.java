package catBook.main.hibernate.DAO.book;

import catBook.main.bean.book.Book;
import genesis.hibernate.DAO.BaseBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends BaseBeanDAO<Book> {

}
