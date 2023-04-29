package catBook.api.DTO.user;

import catBook.api.service.user.UserRoleMapService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapResponseDTO extends GenesisResponseDTO {

    private UserResponseDTO user;

    private UserRoleResponseDTO userRole;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return UserRoleMapService.class;
    }
}
