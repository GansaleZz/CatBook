package catBook.api.transformer.book.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookParametersContainer extends GenesisParametersContainer {

    private String bookName;
}
