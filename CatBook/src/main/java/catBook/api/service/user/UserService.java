package catBook.api.service.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.transformer.user.container.UserParametersContainer;
import catBook.main.bean.user.User;
import genesis.api.BaseCreateService;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/users")
public interface UserService extends BaseCreateService<UserResponseDTO, UserRequestDTO>,
        BaseReadService<UserResponseDTO, User, UserParametersContainer> {

}
