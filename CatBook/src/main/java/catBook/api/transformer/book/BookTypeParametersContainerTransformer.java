package catBook.api.transformer.book;

import catBook.api.transformer.book.container.BookTypeParametersContainer;
import catBook.main.hibernate.criteria.book.BookTypeHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookTypeParametersContainerTransformer extends BaseParametersContainerTransformer<BookTypeParametersContainer, BookTypeHibernateQueryCriteria> {
}
