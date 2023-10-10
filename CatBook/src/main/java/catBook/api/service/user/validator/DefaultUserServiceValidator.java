package catBook.api.service.user.validator;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.service.user.DefaultUserService;
import catBook.main.manager.user.UserManager;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import genesis.util.constant.GenesisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Default validator for {@link DefaultUserService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultUserServiceValidator extends GenesisServiceValidator<UserRequestDTO> {

    public static final int MAX_USERNAME_LENGTH = 16;
    public static final int MAX_DISPLAY_NAME_LENGTH = 16;
    public static final int MAX_PASSWORD_LENGTH = 20;

    @Autowired
    private UserManager userManager;

    @Override
    public void doValidate(BaseRequestResult result, UserRequestDTO userRequestDTO) {
        String userName = userRequestDTO.getUserName();
        String displayName = userRequestDTO.getDisplayName();
        String password = userRequestDTO.getPassword();

        stringValidator.rejectBlank(result, "displayName", displayName);
        stringValidator.rejectBlank(result, "userName", userName);
        stringValidator.rejectBlank(result, "password", password);
        stringValidator.rejectTooLong(result, "displayName", displayName, MAX_DISPLAY_NAME_LENGTH);
        stringValidator.rejectTooLong(result, "userName", userName, MAX_USERNAME_LENGTH);
        stringValidator.rejectTooLong(result, "password", password, MAX_PASSWORD_LENGTH);


        if (!result.getErrors().containsKey("userName") &&
                Optional.ofNullable(userManager.findByUserName(userName)).isPresent()) {
            result.putError("userName", String.format(GenesisConstants.VALIDATION_USER_WITH_USERNAME_EXISTS,
                    userName));
        }
    }
}
