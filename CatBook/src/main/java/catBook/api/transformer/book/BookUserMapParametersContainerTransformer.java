package catBook.api.transformer.book;

import catBook.api.transformer.container.BookUserMapParametersContainer;
import catBook.main.hibernate.criteria.book.BookUserMapHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookUserMapParametersContainerTransformer extends BaseParametersContainerTransformer<BookUserMapParametersContainer, BookUserMapHibernateQueryCriteria> {
}
