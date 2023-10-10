package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.api.transformer.user.container.UserRoleMapParametersContainer;
import catBook.main.bean.user.UserRoleMap;
import catBook.main.hibernate.criteria.user.UserRoleMapHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserRoleMapService extends GenesisCreateService<UserRoleMapResponseDTO, UserRoleMapRequestDTO,
        UserRoleMap, UserRoleMapParametersContainer, UserRoleMapHibernateQueryCriteria> implements UserRoleMapService {

    @Override
    @PreAuthorize("allowsAll()")
    public UserRoleMapResponseDTO save(UserRoleMapRequestDTO userRoleMapRequestDTO) {
        return super.save(userRoleMapRequestDTO);
    }

    @Override
    @PreAuthorize("hasAdminRole()")
    public UserRoleMapResponseDTO remove(UserRoleMapRequestDTO userRoleMapRequestDTO) {
        return super.remove(userRoleMapRequestDTO);
    }
}
