package catBook.api.transformer.locale;

import catBook.api.transformer.locale.container.LocaleParametersContainer;
import catBook.main.hibernate.criteria.locale.LocaleHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocaleParametersContainerTransformer extends BaseParametersContainerTransformer<LocaleParametersContainer, LocaleHibernateQueryCriteria> {
}
