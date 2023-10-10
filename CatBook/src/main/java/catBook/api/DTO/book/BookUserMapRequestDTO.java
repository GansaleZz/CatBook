package catBook.api.DTO.book;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserMapRequestDTO extends GenesisRequestDTO {

    private Long bookID;

    private Long userID;

    private Long bookTypeID;
}
