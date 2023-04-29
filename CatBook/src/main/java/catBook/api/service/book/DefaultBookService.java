package catBook.api.service.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.api.transformer.container.BookParametersContainer;
import catBook.main.bean.Book;
import catBook.main.hibernate.criteria.book.BookHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookService extends GenesisCreateService<BookResponseDTO, BookRequestDTO, Book, BookParametersContainer, BookHibernateQueryCriteria>
        implements BookService {
}
