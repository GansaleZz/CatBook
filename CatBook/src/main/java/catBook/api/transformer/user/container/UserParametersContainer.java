package catBook.api.transformer.user.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserParametersContainer extends GenesisParametersContainer {

    private String userName;

    private String displayName;
}
