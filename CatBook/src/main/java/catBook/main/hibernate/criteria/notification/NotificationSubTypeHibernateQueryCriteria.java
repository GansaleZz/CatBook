package catBook.main.hibernate.criteria.notification;

import catBook.main.bean.notification.NotificationSubType;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationSubTypeHibernateQueryCriteria extends GenesisHibernateQueryCriteria<NotificationSubType> {

    @Criteria(name = "notificationSubTypeName")
    private String notificationSubTypeName = null;

    @Criteria(name = "notificationType")
    private Long notificationTypeID = GenesisConstants.EMPTY_LONG;

    @Override
    public Class<NotificationSubType> getBeanClass() {
        return NotificationSubType.class;
    }
}
