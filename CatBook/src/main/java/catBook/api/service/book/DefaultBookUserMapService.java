package catBook.api.service.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.api.transformer.book.container.BookUserMapParametersContainer;
import catBook.main.bean.book.BookUserMap;
import catBook.main.hibernate.criteria.book.BookUserMapHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookUserMapService
        extends GenesisCreateService<BookUserMapResponseDTO, BookUserMapRequestDTO, BookUserMap, BookUserMapParametersContainer, BookUserMapHibernateQueryCriteria>
        implements BookUserMapService {
}
