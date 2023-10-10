package catBook.api.service.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.transformer.user.container.UserParametersContainer;
import catBook.main.bean.user.User;
import genesis.api.BaseCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public interface UserService extends BaseCreateService<UserResponseDTO, User, UserRequestDTO> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<UserResponseDTO>> findAll(PageFilter pageFilter,
                                                                      UserParametersContainer container);
}
