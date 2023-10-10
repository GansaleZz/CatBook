package catBook.api.service.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.transformer.user.container.UserParametersContainer;
import catBook.main.bean.user.User;
import catBook.main.hibernate.criteria.user.UserHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserService extends GenesisCreateService<UserResponseDTO, UserRequestDTO, User,
        UserParametersContainer, UserHibernateQueryCriteria> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("allowsAll()")
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        return super.save(userRequestDTO);
    }

    @Override
    public void beforeSave(UserRequestDTO userRequestDTO) {
        super.beforeSave(userRequestDTO);

        userRequestDTO.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
    }

    @Override
    @PreAuthorize("hasAdminRole()")
    public UserResponseDTO remove(UserRequestDTO userRequestDTO) {
        return super.remove(userRequestDTO);
    }
}
