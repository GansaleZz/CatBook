package catBook.api.transformer.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleParametersContainer extends GenesisParametersContainer {

    private String userRoleName;
}
