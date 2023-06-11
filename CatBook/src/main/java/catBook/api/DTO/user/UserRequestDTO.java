package catBook.api.DTO.user;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO extends GenesisRequestDTO {

    private String login;

    private String userName;

    private String password;
}
