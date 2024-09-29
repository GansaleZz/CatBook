package catBook.main.hibernate.DAO.notification;

import catBook.main.bean.notification.NotificationMessage;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultNotificationMessageDAO extends GenesisHibernateBeanDAO<NotificationMessage> {
}
