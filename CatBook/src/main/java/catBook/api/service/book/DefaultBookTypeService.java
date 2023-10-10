package catBook.api.service.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.api.transformer.book.container.BookTypeParametersContainer;
import catBook.main.bean.book.BookType;
import catBook.main.hibernate.criteria.book.BookTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookTypeService extends GenesisReadService<BookTypeResponseDTO, BookType> implements BookTypeService {

    @Override
    public CollectionModel<EntityModel<BookTypeResponseDTO>> findAll(PageFilter pageFilter, BookTypeParametersContainer container) {
        BookTypeHibernateQueryCriteria criteria = new BookTypeHibernateQueryCriteria();

        if (container.getBookTypeName() != null) {
            criteria.setBookTypeName(container.getBookTypeName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
