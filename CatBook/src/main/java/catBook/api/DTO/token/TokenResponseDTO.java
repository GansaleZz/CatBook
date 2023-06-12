package catBook.api.DTO.token;

import catBook.api.service.token.TokenService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDTO extends GenesisResponseDTO {

    private String tokenName;

    private String tokenValue;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return TokenService.class;
    }
}
