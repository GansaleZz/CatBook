package genesis.api;

import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenesisParametersContainer {

    private Long ID = GenesisConstants.EMPTY_LONG;

    private Long createdByID = GenesisConstants.EMPTY_LONG;

    private Long modifiedByID = GenesisConstants.EMPTY_LONG;

    private Boolean active;
}
