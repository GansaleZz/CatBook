package catBook.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

/**
 * Class with methods that helps utilize JWT.
 */
@Component
public final class JWTUtil {

    @Value("${app.JWTSecret}")
    private String JWTSecretKey;
    @Value("${app.JWTExpirationMs}")
    private int JWTExpirationMs;

    /**
     * Creates JWT using provided username and security secret key.
     *
     * @param username
     * @return
     */
    public String createJWT(String username) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWTExpirationMs))
                .signWith(SignatureAlgorithm.HS512, JWTSecretKey)
                .compact();
    }

    /**
     * Get JWT from request header and cut substring = "Bearer " from it.
     *
     * @param request
     * @return
     */
    public String parseJWT(HttpServletRequest request) {
        String JWT = request.getHeader("Authorization");
        if (Optional.ofNullable(JWT).isPresent())
        {
            JWT = JWT.substring(7);
        }

        return JWT;
    }

    /**
     * Validate JWT. If provided token is matching security secret key then return true, otherwise return false.
     *
     * @param JWT
     * @return
     */
    public boolean validateJWT(String JWT) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(JWTSecretKey)
                    .build()
                    .parseClaimsJws(JWT);

            return true;
        } catch (MalformedJwtException | IllegalArgumentException | SignatureException e) {
            return false;
        }
    }

    /**
     * Return username by parsing provided JWT using security secret key.
     *
     * @param JWT
     * @return username.
     */
    public String getUserNameFromJWT(String JWT) {
        return Jwts.parserBuilder()
                .setSigningKey(JWTSecretKey)
                .build()
                .parseClaimsJws(JWT)
                .getBody()
                .getSubject();
    }
}
