package catBook.main.manager.notification;

import catBook.main.bean.notification.Notification;
import genesis.manager.GenesisManager;

import java.util.List;

public abstract class NotificationManager extends GenesisManager<Notification> {

    public abstract List<Notification> findByUserID(long userID);
}
