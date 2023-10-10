package catBook.api.DTO.user;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO extends GenesisRequestDTO {

    private String displayName;

    private String userName;

    private String password;
}
