package catBook.main.manager.user;

import catBook.main.bean.user.UserRole;
import catBook.main.bean.user.UserRoleMap;
import genesis.manager.GenesisManager;

import java.util.List;

/**
 *
 * @author GansaleZz
 */
public abstract class UserRoleMapManager extends GenesisManager<UserRoleMap> {

    /**
     * Return {@link UserRoleMap}s found by userID.
     *
     * @param userID
     * @return
     */
    public abstract List<UserRoleMap> findActiveByUserID(long userID);

    /**
     * Return {@link UserRoleMap} found by userID and userRoleID.
     *
     * @param userID
     * @param userRoleID
     * @return
     */
    public abstract UserRoleMap findActiveByUserIDAndUserRoleID(long userID, long userRoleID);

    /**
     * Return {@link UserRole} that has maximum value found by userID.
     *
     * @param userID
     * @return
     */
    public abstract UserRole findMaxUserRoleByUserID(long userID);
}
