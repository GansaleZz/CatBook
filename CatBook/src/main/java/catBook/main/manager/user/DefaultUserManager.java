package catBook.main.manager.user;

import catBook.main.manager.book.BookUserMapManager;
import catBook.main.manager.notification.NotificationManager;
import catBook.main.manager.user.userDetails.DefaultUserDetails;
import catBook.main.bean.user.User;
import catBook.main.bean.user.UserRole;
import catBook.main.hibernate.DAO.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Default implementation of {@link UserManager}.
 *
 * @author GansaleZz
 */
@Service
public class DefaultUserManager extends UserManager {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleMapManager userRoleMapManager;

    @Autowired
    private BookUserMapManager bookUserMapManager;

    @Autowired
    private NotificationManager notificationManager;

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserNameAndActive(userName, true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        UserDetails result = null;

        if (Optional.ofNullable(user).isPresent()) {
            UserRole userRole = userRoleMapManager.findMaxUserRoleByUserID(user.getID());

            result = DefaultUserDetails.builder()
                    .password(user.getPassword())
                    .userName(username)
                    .authorities(Collections.singleton(new SimpleGrantedAuthority(userRole.getUserRoleName())))
                    .build();
        }

        return result;
    }

    @Override
    protected void removeDependencies(User user) {
        long userID = user.getID();

        userRoleMapManager.findActiveByUserID(userID).forEach(userRoleMapManager::remove);
        bookUserMapManager.findByUserID(userID).forEach(bookUserMapManager::remove);
        notificationManager.findByUserID(userID).forEach(notificationManager::remove);
    }
}
