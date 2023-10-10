package catBook.main.manager.notification;

import catBook.main.bean.notification.NotificationMessage;
import genesis.manager.GenesisManager;

public abstract class NotificationMessageManager extends GenesisManager<NotificationMessage> {

    public abstract NotificationMessage findByNotificationSubTypeIDAndLocaleID(long notificationSubTypeID, long localeID);
}
