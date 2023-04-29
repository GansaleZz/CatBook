package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.api.transformer.container.UserRoleParametersContainer;
import catBook.main.bean.UserRole;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/userRoles")
public interface UserRoleService extends BaseReadService<UserRoleResponseDTO, UserRole, UserRoleParametersContainer> {

}
