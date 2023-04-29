package catBook.api.transformer.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapParametersContainer extends GenesisParametersContainer {

    private long userID = GenesisConstants.EMPTY_LONG;

    private long userRoleID = GenesisConstants.EMPTY_LONG;
}
