package catBook.api.service.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.transformer.user.container.UserParametersContainer;
import catBook.main.bean.user.User;
import catBook.main.hibernate.criteria.user.UserHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserService extends GenesisCreateService<UserResponseDTO, UserRequestDTO, User, UserParametersContainer, UserHibernateQueryCriteria>
        implements UserService {

}
