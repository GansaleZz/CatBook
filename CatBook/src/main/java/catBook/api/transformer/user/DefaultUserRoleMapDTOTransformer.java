package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.main.bean.user.UserRoleMap;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserRoleMapDTOTransformer extends GenesisResponseDTOTransformer<UserRoleMapResponseDTO, UserRoleMap>
        implements UserRoleMapDTOTransformer {

    @Autowired
    private UserRoleDTOTransformer userRoleDTOTransformer;

    @Autowired
    private UserDTOTransformer userDTOTransformer;

    @Override
    protected Class<UserRoleMapResponseDTO> getResponseDTOClass() {
        return UserRoleMapResponseDTO.class;
    }

    @Override
    protected void transformCustomData(UserRoleMapResponseDTO userRoleMapResponseDTO, UserRoleMap userRoleMap) {
        userRoleMapResponseDTO.setUser(userDTOTransformer.transformToResponseDTO(userRoleMap.getUser()));
        userRoleMapResponseDTO.setUserRole(userRoleDTOTransformer.transformToResponseDTO(userRoleMap.getUserRole()));
    }
}
