package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.api.transformer.user.container.UserRoleParametersContainer;
import catBook.main.bean.user.UserRole;
import catBook.main.hibernate.criteria.user.UserRoleHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserRoleService extends GenesisReadService<UserRoleResponseDTO, UserRole> implements UserRoleService  {

    @Override
    public CollectionModel<EntityModel<UserRoleResponseDTO>> findAll(PageFilter pageFilter, UserRoleParametersContainer container) {
        UserRoleHibernateQueryCriteria criteria = new UserRoleHibernateQueryCriteria();

        if (container.getUserRoleName() != null) {
            criteria.setUserRoleName(criteria.getUserRoleName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
