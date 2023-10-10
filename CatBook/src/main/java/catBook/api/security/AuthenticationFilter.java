package catBook.api.security;

import catBook.main.bean.locale.Locale;
import catBook.main.bean.user.User;
import catBook.main.manager.application.ApplicationSessionHelper;
import catBook.main.manager.locale.LocaleManager;
import catBook.main.manager.user.UserManager;
import genesis.util.constant.GenesisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private ApplicationSessionHelper applicationSessionHelper;
    @Autowired
    private UserManager userManager;
    @Autowired
    private LocaleManager localeManager;
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String JWT = jwtUtil.parseJWT(request);

            if (Optional.ofNullable(JWT).isPresent() && jwtUtil.validateJWT(JWT)) {
                String userName = jwtUtil.getUserNameFromJWT(JWT);
                User user = userManager.findByUserName(userName);

                if (Optional.ofNullable(user).isPresent()) {
                    applicationSessionHelper.setUser(user);
                }

                UserDetails userDetails = userManager.loadUserByUsername(userName);
                if (Optional.ofNullable(userDetails).isPresent()) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            String localeName = request.getParameter("locale");
            populateApplicationSessionLocale(localeName);
        }

        filterChain.doFilter(request, response);
    }

    /**
     *
     *
     * @param localeName
     */
    private void populateApplicationSessionLocale(String localeName) {
        Locale locale = localeManager.findByLocaleName(localeName);

        applicationSessionHelper.setLocale(Optional.ofNullable(locale).isEmpty() ?
                localeManager.findByID(GenesisConstants.LOCALE_ENGLISH_ID) :
                locale);
    }
}
