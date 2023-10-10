package catBook.api.service.user;

import catBook.api.DTO.user.JWTRequestDTO;
import catBook.api.DTO.user.JWTResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contains methods that allows {@link catBook.main.bean.user.User} to signIn and signUp on application.
 */
@RequestMapping("/authenticate")
public interface AuthenticationService {

    @PostMapping("/signIn")
    ResponseEntity<JWTResponseDTO> signIn(@RequestBody JWTRequestDTO jwtRequestDTO);

    @PostMapping("/signUp")
    ResponseEntity<JWTResponseDTO> signUp(@RequestBody JWTRequestDTO jwtRequestDTO);

    void beforeSignUp(JWTRequestDTO jwtRequestDTO);

    void beforeSignIn(JWTRequestDTO jwtRequestDTO);
}
