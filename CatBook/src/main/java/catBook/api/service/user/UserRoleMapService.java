package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.api.transformer.user.container.UserRoleMapParametersContainer;
import catBook.main.bean.user.UserRoleMap;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/userRoleMaps")
public interface UserRoleMapService extends BaseReadService<UserRoleMapResponseDTO, UserRoleMap, UserRoleMapParametersContainer> {

}
