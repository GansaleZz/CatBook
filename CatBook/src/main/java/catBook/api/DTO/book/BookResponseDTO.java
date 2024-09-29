package catBook.api.DTO.book;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO extends GenesisResponseDTO {

    private String bookName;
}
