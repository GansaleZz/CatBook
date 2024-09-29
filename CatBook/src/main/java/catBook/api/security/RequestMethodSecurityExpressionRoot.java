package catBook.api.security;

import catBook.main.bean.user.User;
import catBook.main.manager.application.ApplicationSessionHelper;
import catBook.main.manager.user.UserRoleMapManager;
import genesis.util.constant.GenesisConstants;
import lombok.Setter;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Class that allows to define methods that will check if user has necessary role.
 *
 * @author GansaleZz
 */
public class RequestMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    @Setter
    private UserRoleMapManager userRoleMapManager;
    @Setter
    private ApplicationSessionHelper applicationSessionHelper;
    private HttpServletRequest request;
    private Object filterObject;
    private Object returnObject;
    private Object target;

    public RequestMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean hasAdminRole() {
        Optional<User> user = Optional.ofNullable(applicationSessionHelper.getUser());

        return user.isPresent() &&
                Optional.ofNullable(userRoleMapManager.findActiveByUserIDAndUserRoleID(user.get().getID(),
                        GenesisConstants.USER_ADMIN_ROLE_ID)).isPresent();
    }

    public boolean hasClientRole() {
        Optional<User> user = Optional.ofNullable(applicationSessionHelper.getUser());

        return user.isPresent() &&
                Optional.ofNullable(userRoleMapManager.findActiveByUserIDAndUserRoleID(user.get().getID(),
                        GenesisConstants.USER_CLIENT_ROLE_ID)).isPresent();
    }

    public boolean allowsAll() {
        return true;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return target;
    }
}
