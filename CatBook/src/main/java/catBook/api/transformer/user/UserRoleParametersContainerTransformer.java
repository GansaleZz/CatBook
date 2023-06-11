package catBook.api.transformer.user;

import catBook.api.transformer.container.UserRoleParametersContainer;
import catBook.main.hibernate.criteria.user.UserRoleHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleParametersContainerTransformer extends BaseParametersContainerTransformer<UserRoleParametersContainer, UserRoleHibernateQueryCriteria> {
}
