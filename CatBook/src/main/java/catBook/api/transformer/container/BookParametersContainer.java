package catBook.api.transformer.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookParametersContainer extends GenesisParametersContainer {

    private long bookTypeID = GenesisConstants.EMPTY_LONG;

    private String bookName;
}
