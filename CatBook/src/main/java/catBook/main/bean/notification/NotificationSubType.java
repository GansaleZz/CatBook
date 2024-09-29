package catBook.main.bean.notification;

import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Contains data of entity Notification Sub Type.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_NotificationSubType")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationSubType extends GenesisBean {

    @Column(name = "NotificationSubTypeName")
    private String notificationSubTypeName;

    @ManyToOne
    @JoinColumn(name = "NotificationTypeID", referencedColumnName = "ID")
    private NotificationType notificationType;
}
