package catBook.main.hibernate.criteria.notification;

import catBook.main.bean.notification.NotificationMessage;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessageHibernateQueryCriteria extends GenesisHibernateQueryCriteria<NotificationMessage> {

    @Override
    public Class<NotificationMessage> getBeanClass() {
        return NotificationMessage.class;
    }

    @Criteria(name = "notificationMessageValue")
    private String notificationMessageValue;

    @Criteria(name = "locale")
    private Long localeID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "notificationSubType")
    private Long notificationSubTypeID = GenesisConstants.EMPTY_LONG;
}
