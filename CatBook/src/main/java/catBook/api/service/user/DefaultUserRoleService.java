package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.api.transformer.user.container.UserRoleParametersContainer;
import catBook.main.bean.user.UserRole;
import catBook.main.hibernate.criteria.user.UserRoleHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserRoleService extends GenesisReadService<UserRoleResponseDTO, UserRole, UserRoleParametersContainer, UserRoleHibernateQueryCriteria>
        implements UserRoleService  {
}
