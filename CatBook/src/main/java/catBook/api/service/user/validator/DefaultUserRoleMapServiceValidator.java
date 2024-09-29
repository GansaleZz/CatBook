package catBook.api.service.user.validator;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.main.bean.user.User;
import catBook.main.bean.user.UserRole;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;


@Component
public class DefaultUserRoleMapServiceValidator extends GenesisServiceValidator<UserRoleMapRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, UserRoleMapRequestDTO userRoleMapRequestDTO) {
        idValidator.rejectInvalidID(result, userRoleMapRequestDTO.getUserID(), "userID", User.class);
        idValidator.rejectInvalidID(result, userRoleMapRequestDTO.getUserRoleID(), "userRoleID", UserRole.class);
    }
}
