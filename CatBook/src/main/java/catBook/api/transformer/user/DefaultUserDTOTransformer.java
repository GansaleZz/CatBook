package catBook.api.transformer.user;

import catBook.api.DTO.user.UserResponseDTO;
import catBook.main.bean.user.User;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserDTOTransformer extends GenesisResponseDTOTransformer<UserResponseDTO, User>
        implements UserDTOTransformer {

    @Override
    protected Class<UserResponseDTO> getResponseDTOClass() {
        return UserResponseDTO.class;
    }

    @Override
    protected void transformCustomData(UserResponseDTO userResponseDTO, User user) {
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setDisplayName(user.getDisplayName());
    }
}
