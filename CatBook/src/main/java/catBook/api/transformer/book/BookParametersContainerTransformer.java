package catBook.api.transformer.book;

import catBook.api.transformer.book.container.BookParametersContainer;
import catBook.main.hibernate.criteria.book.BookHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookParametersContainerTransformer extends BaseParametersContainerTransformer<BookParametersContainer, BookHibernateQueryCriteria> {
}
