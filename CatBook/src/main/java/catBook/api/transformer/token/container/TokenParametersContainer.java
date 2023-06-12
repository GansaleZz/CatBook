package catBook.api.transformer.token.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenParametersContainer extends GenesisParametersContainer {

    private String tokenName;

    private String tokenValue;
}
