package catBook.api.service.user;

import catBook.api.DTO.user.*;
import catBook.api.security.JWTUtil;
import catBook.main.bean.user.User;
import catBook.main.manager.user.UserManager;
import genesis.api.GenesisServiceValidator;
import genesis.util.constant.GenesisConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link AuthenticationService}.
 */
@Service
@Log4j2
public class DefaultAuthenticationService implements AuthenticationService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserRoleMapService userRoleMapService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GenesisServiceValidator<JWTRequestDTO> validator;

    @Override
    public ResponseEntity<JWTResponseDTO> signIn(JWTRequestDTO jwtRequestDTO) {
        beforeSignIn(jwtRequestDTO);

        String username = jwtRequestDTO.getUserName();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        username,
                        jwtRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userManager.findByUserName(username);

        JWTResponseDTO jwtResponseDTO = new JWTResponseDTO();
        jwtResponseDTO.setJWT(jwtUtil.createJWT(user.getUserName()));
        jwtResponseDTO.setDisplayName(user.getDisplayName());

        log.info(username + " successfully signed in!");

        return ResponseEntity.ok(jwtResponseDTO);
    }

    @Override
    public ResponseEntity<JWTResponseDTO> signUp(JWTRequestDTO jwtRequestDTO) {
        beforeSignUp(jwtRequestDTO);

        String username = jwtRequestDTO.getUserName();
        String displayName = jwtRequestDTO.getDisplayName();

        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserName(username);
        userRequestDTO.setDisplayName(displayName);
        userRequestDTO.setPassword(jwtRequestDTO.getPassword());
        UserResponseDTO userResponseDTO = userService.save(userRequestDTO);

        UserRoleMapRequestDTO userRoleMapRequestDTO = new UserRoleMapRequestDTO();
        userRoleMapRequestDTO.setUserID(userResponseDTO.getID());
        userRoleMapRequestDTO.setUserRoleID(GenesisConstants.USER_CLIENT_ROLE_ID);
        userRoleMapService.save(userRoleMapRequestDTO);

        JWTResponseDTO jwtResponseDTO = new JWTResponseDTO();
        jwtResponseDTO.setJWT(jwtUtil.createJWT(username));
        jwtResponseDTO.setDisplayName(displayName);

        log.info(username + " successfully signed up!");

        return ResponseEntity.ok(jwtResponseDTO);
    }

    @Override
    public void beforeSignUp(JWTRequestDTO jwtRequestDTO) {
        validator.validate(jwtRequestDTO);
    }

    @Override
    public void beforeSignIn(JWTRequestDTO jwtRequestDTO) {
        validator.validate(jwtRequestDTO);
    }
}
