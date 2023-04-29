package catBook.api.transformer.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserMapParametersContainer extends GenesisParametersContainer {

    private long bookID = GenesisConstants.EMPTY_LONG;

    private long userID = GenesisConstants.EMPTY_LONG;
}
