package catBook.main.hibernate.criteria.notification;

import catBook.main.bean.notification.NotificationStatus;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationStatusHibernateQueryCriteria extends GenesisHibernateQueryCriteria<NotificationStatus> {

    @Override
    public Class<NotificationStatus> getBeanClass() {
        return NotificationStatus.class;
    }

    @Criteria(name = "notificationStatusName")
    private String notificationStatusName = null;
}
