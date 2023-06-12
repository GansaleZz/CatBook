package catBook.main.hibernate.DAO.notification;

import catBook.main.bean.notification.Notification;
import genesis.hibernate.DAO.BaseBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO extends BaseBeanDAO<Notification> {
}
