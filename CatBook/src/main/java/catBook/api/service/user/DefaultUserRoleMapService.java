package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.api.transformer.user.container.UserRoleMapParametersContainer;
import catBook.main.bean.user.UserRoleMap;
import catBook.main.hibernate.criteria.user.UserRoleMapHibernateQueryCriteria;
import catBook.main.manager.user.UserManager;
import catBook.main.manager.user.UserRoleManager;
import genesis.api.GenesisCreateService;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserRoleMapService extends GenesisCreateService<UserRoleMapResponseDTO, UserRoleMap, UserRoleMapRequestDTO>
        implements UserRoleMapService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserRoleManager userRoleManager;

    @PreAuthorize("allowsAll()")
    @Override
    protected UserRoleMap doSave(UserRoleMapRequestDTO userRoleMapRequestDTO) {
        UserRoleMap userRoleMap = new UserRoleMap();
        userRoleMap.setUser(userManager.findByID(userRoleMapRequestDTO.getUserID()));
        userRoleMap.setUserRole(userRoleManager.findByID(userRoleMapRequestDTO.getUserRoleID()));

        return manager.save(userRoleMap);
    }

    @PreAuthorize("hasAdminRole()")
    @Override
    protected UserRoleMap doRemove(UserRoleMapRequestDTO userRoleMapRequestDTO) {
        return manager.remove(manager.findByID(userRoleMapRequestDTO.getUserRoleMapID()));
    }

    @Override
    public CollectionModel<EntityModel<UserRoleMapResponseDTO>> findAll(PageFilter pageFilter, UserRoleMapParametersContainer container) {
        UserRoleMapHibernateQueryCriteria criteria = new UserRoleMapHibernateQueryCriteria();

        if (container.getUserID() != GenesisConstants.EMPTY_LONG) {
            criteria.setUserID(container.getUserID());
        }

        if (container.getUserRoleID() != GenesisConstants.EMPTY_LONG) {
            criteria.setUserRoleID(container.getUserRoleID());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
