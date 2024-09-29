package catBook.main.manager.user;

import catBook.main.bean.user.User;
import genesis.manager.GenesisManager;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author GansaleZz
 */
public abstract class UserManager extends GenesisManager<User> implements UserDetailsService {

    public abstract User findByUserName(String userName);
}
