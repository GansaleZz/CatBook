package catBook.api.DTO.user;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO extends GenesisResponseDTO {

    private String userName;

    private String displayName;
}
