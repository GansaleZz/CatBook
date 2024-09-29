package catBook.main.hibernate.DAO.notification;

import catBook.main.bean.notification.NotificationMessage;
import genesis.hibernate.DAO.BaseBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMessageDAO extends BaseBeanDAO<NotificationMessage> {
}
