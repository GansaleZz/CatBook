package catBook.api.service.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.transformer.user.container.UserParametersContainer;
import catBook.main.bean.user.User;
import catBook.main.hibernate.criteria.user.UserHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserService extends GenesisCreateService<UserResponseDTO, User, UserRequestDTO>
        implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("allowsAll()")
    @Override
    protected User doSave(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setDisplayName(userRequestDTO.getDisplayName());
        user.setPassword(userRequestDTO.getPassword());

        return manager.save(user);
    }

    @PreAuthorize("hasAdminRole()")
    @Override
    protected User doRemove(UserRequestDTO userRequestDTO) {
        return manager.remove(manager.findByID(userRequestDTO.getUserID()));
    }

    @Override
    public void beforeSave(UserRequestDTO userRequestDTO) {
        super.beforeSave(userRequestDTO);

        userRequestDTO.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
    }

    @Override
    public CollectionModel<EntityModel<UserResponseDTO>> findAll(PageFilter pageFilter, UserParametersContainer container) {
        UserHibernateQueryCriteria criteria = new UserHibernateQueryCriteria();

        if (container.getUserName() != null) {
            criteria.setUserName(container.getUserName());
        }

        if (container.getDisplayName() != null) {
            criteria.setDisplayName(container.getDisplayName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
