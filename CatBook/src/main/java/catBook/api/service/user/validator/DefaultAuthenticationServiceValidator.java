package catBook.api.service.user.validator;

import catBook.api.DTO.user.JWTRequestDTO;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

import static catBook.api.service.user.validator.DefaultUserServiceValidator.*;

/**
 * Default validator for {@link catBook.api.service.user.AuthenticationService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultAuthenticationServiceValidator extends GenesisServiceValidator<JWTRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, JWTRequestDTO jwtRequestDTO) {
        String userName = jwtRequestDTO.getUserName();
        String password = jwtRequestDTO.getPassword();
        stringValidator.rejectBlank(result, "userName", jwtRequestDTO.getUserName());
        stringValidator.rejectBlank(result, "password", password);
        stringValidator.rejectTooLong(result, "userName", userName, MAX_USERNAME_LENGTH);
        stringValidator.rejectTooLong(result, "password", password, MAX_PASSWORD_LENGTH);
    }
}
