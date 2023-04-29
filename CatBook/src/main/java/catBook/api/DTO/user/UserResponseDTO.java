package catBook.api.DTO.user;

import catBook.api.service.user.UserService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO extends GenesisResponseDTO {

    private String userName;

    private String login;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return UserService.class;
    }
}
