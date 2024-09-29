package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.api.transformer.user.container.UserRoleMapParametersContainer;
import catBook.main.bean.user.UserRoleMap;
import genesis.api.BaseCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/userRoleMaps")
public interface UserRoleMapService extends BaseCreateService<UserRoleMapResponseDTO, UserRoleMap, UserRoleMapRequestDTO> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<UserRoleMapResponseDTO>> findAll(PageFilter pageFilter,
                                                          UserRoleMapParametersContainer container);
}
