package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.main.bean.user.UserRole;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserRoleDTOTransformer extends GenesisResponseDTOTransformer<UserRoleResponseDTO, UserRole>
        implements UserRoleDTOTransformer {

    @Override
    protected Class<UserRoleResponseDTO> getResponseDTOClass() {
        return UserRoleResponseDTO.class;
    }

    @Override
    protected void transformCustomData(UserRoleResponseDTO userRoleResponseDTO, UserRole userRole) {
        userRoleResponseDTO.setUserRoleName(userRole.getUserRoleName());
    }
}
