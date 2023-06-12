package catBook.main.hibernate.criteria.notification;

import catBook.main.bean.notification.Notification;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationHibernateQueryCriteria extends GenesisHibernateQueryCriteria<Notification> {

    @Override
    public Class<Notification> getBeanClass() {
        return Notification.class;
    }

    @Criteria(name = "notificationType")
    private Long notificationTypeID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "notificationStatus")
    private Long notificationStatusID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "user")
    private Long userID = GenesisConstants.EMPTY_LONG;
}
