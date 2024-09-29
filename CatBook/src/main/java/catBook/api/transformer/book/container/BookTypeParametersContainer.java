package catBook.api.transformer.book.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTypeParametersContainer extends GenesisParametersContainer {

    private String bookTypeName;
}
