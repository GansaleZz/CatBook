package catBook.api.service.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.api.transformer.user.container.UserRoleParametersContainer;
import catBook.main.bean.user.UserRole;
import genesis.api.BaseReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/userRoles")
public interface UserRoleService extends BaseReadService<UserRoleResponseDTO, UserRole> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<UserRoleResponseDTO>> findAll(PageFilter pageFilter,
                                                          UserRoleParametersContainer container);
}
