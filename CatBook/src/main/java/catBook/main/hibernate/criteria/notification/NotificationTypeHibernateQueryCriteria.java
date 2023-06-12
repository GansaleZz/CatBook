package catBook.main.hibernate.criteria.notification;

import catBook.main.bean.notification.NotificationType;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTypeHibernateQueryCriteria extends GenesisHibernateQueryCriteria<NotificationType> {

    @Override
    public Class<NotificationType> getBeanClass() {
        return NotificationType.class;
    }

    @Criteria(name = "notificationTypeName")
    private String notificationTypeName = null;
}
