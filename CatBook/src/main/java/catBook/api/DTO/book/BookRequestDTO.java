package catBook.api.DTO.book;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDTO extends GenesisRequestDTO {

    private String bookName;

    private long bookTypeID;
}
