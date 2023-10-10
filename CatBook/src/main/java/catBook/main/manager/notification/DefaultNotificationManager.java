package catBook.main.manager.notification;

import catBook.main.bean.notification.Notification;
import catBook.main.hibernate.criteria.notification.NotificationHibernateQueryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultNotificationManager extends NotificationManager {

    @Override
    public List<Notification> findByUserID(long userID) {
        NotificationHibernateQueryCriteria criteria = new NotificationHibernateQueryCriteria();
        criteria.setUserID(userID);
        criteria.setActive(true);

        return findAll(criteria);
    }
}
