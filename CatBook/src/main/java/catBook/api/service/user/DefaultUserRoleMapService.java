package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.api.transformer.user.container.UserRoleMapParametersContainer;
import catBook.main.bean.user.UserRoleMap;
import catBook.main.hibernate.criteria.user.UserRoleMapHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserRoleMapService extends GenesisReadService<UserRoleMapResponseDTO, UserRoleMap, UserRoleMapParametersContainer, UserRoleMapHibernateQueryCriteria>
        implements UserRoleMapService {

}
