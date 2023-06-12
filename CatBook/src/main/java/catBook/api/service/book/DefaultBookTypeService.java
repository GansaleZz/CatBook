package catBook.api.service.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.api.transformer.book.container.BookTypeParametersContainer;
import catBook.main.bean.book.BookType;
import catBook.main.hibernate.criteria.book.BookTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookTypeService extends GenesisReadService<BookTypeResponseDTO, BookType, BookTypeParametersContainer, BookTypeHibernateQueryCriteria>
        implements BookTypeService {
}
