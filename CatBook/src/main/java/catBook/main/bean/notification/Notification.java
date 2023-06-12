package catBook.main.bean.notification;

import catBook.main.bean.user.User;
import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Contains data of entity Notification.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_Notification")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends GenesisBean {

    @ManyToOne
    @JoinColumn(name = "NotificationTypeID", referencedColumnName = "ID")
    private NotificationType notificationType;

    @ManyToOne
    @JoinColumn(name = "NotificationStatusID", referencedColumnName = "ID")
    private NotificationStatus notificationStatus;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    private User user;
}
