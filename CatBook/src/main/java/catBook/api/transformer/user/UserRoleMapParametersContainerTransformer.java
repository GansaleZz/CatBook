package catBook.api.transformer.user;

import catBook.api.transformer.container.UserRoleMapParametersContainer;
import catBook.main.hibernate.criteria.user.UserRoleMapHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapParametersContainerTransformer extends BaseParametersContainerTransformer<UserRoleMapParametersContainer, UserRoleMapHibernateQueryCriteria> {
}
