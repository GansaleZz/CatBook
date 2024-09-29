package catBook.main.hibernate.DAO.user;

import catBook.main.bean.user.UserRoleMap;
import genesis.hibernate.DAO.BaseBeanDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapDAO extends BaseBeanDAO<UserRoleMap> {

    List<UserRoleMap> findByUser_IDAndActive(long userID, boolean active);

    UserRoleMap findByUser_IDAndUserRole_IDAndActive(long userID, long userRoleID, boolean active);
}
