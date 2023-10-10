package catBook.main.manager.notification;

import catBook.main.bean.notification.NotificationMessage;
import catBook.main.hibernate.criteria.notification.NotificationMessageHibernateQueryCriteria;
import org.springframework.stereotype.Service;

@Service
public class DefaultNotificationMessageManager extends NotificationMessageManager {

    @Override
    public NotificationMessage findByNotificationSubTypeIDAndLocaleID(long notificationSubTypeID, long localeID) {
        NotificationMessageHibernateQueryCriteria criteria = new NotificationMessageHibernateQueryCriteria();
        criteria.setNotificationSubTypeID(notificationSubTypeID);
        criteria.setLocaleID(localeID);
        criteria.setActive(true);

        return findSingleByCriteria(criteria);
    }
}
