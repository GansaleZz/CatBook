package catBook.api.DTO.user;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO which provide information about attempt of user to signIn or signUp.
 *
 * @author GansaleZz
 */
@Setter
@Getter
public class JWTRequestDTO extends GenesisRequestDTO {

    private String displayName;

    private String userName;

    private String password;
}
