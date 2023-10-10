package catBook.api.DTO.book;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTypeResponseDTO extends GenesisResponseDTO {

    private String bookTypeName;
}
