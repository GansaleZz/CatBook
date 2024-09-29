package catBook.api.DTO.book;

import catBook.api.DTO.user.UserResponseDTO;
import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserMapResponseDTO extends GenesisResponseDTO {

    private BookResponseDTO book;

    private UserResponseDTO user;

    private BookTypeResponseDTO bookType;
}
