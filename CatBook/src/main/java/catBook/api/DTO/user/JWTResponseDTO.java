package catBook.api.DTO.user;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO which return displayName of user and JWT after successful attempt to signIn or signUp.
 *
 * @author GansaleZz
 */
@Setter
@Getter
public class JWTResponseDTO {

    private String displayName;

    private String JWT;
}
