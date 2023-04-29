package catBook.api.transformer.user;

import catBook.api.transformer.container.UserParametersContainer;
import catBook.main.hibernate.criteria.user.UserHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserParametersContainerTransformer extends BaseParametersContainerTransformer<UserParametersContainer, UserHibernateQueryCriteria> {
}
