package catBook.main.manager.user;

import catBook.main.bean.user.UserRole;
import catBook.main.bean.user.UserRoleMap;
import catBook.main.hibernate.DAO.user.UserRoleMapDAO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Default implementation of {@link UserRoleMapManager}.
 *
 * @author GansaleZz
 */
@Service
public class DefaultUserRoleMapManager extends UserRoleMapManager {

    @Autowired
    private UserRoleMapDAO userRoleMapDAO;

    @Override
    public List<UserRoleMap> findActiveByUserID(long userID) {
        return userRoleMapDAO.findByUser_IDAndActive(userID, true);
    }

    @Override
    public UserRoleMap findActiveByUserIDAndUserRoleID(long userID, long userRoleID) {
        return userRoleMapDAO.findByUser_IDAndUserRole_IDAndActive(userID, userRoleID, true);
    }

    @Override
    public UserRole findMaxUserRoleByUserID(long userID) {
        List<UserRoleMap> userRoleMaps = findActiveByUserID(userID);
        UserRole userRole = null;

        if (CollectionUtils.isNotEmpty(userRoleMaps)) {
            userRole = userRoleMaps.stream()
                    .map(UserRoleMap::getUserRole)
                    .max(Comparator.comparingInt(UserRole::getValue))
                    .get();
        }

        return userRole;
    }
}
