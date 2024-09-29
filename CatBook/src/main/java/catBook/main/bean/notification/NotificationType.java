package catBook.main.bean.notification;

import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contains data of entity Notification Type.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_NotificationType")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationType extends GenesisBean {

    @Column(name = "NotificationTypeName")
    private String notificationTypeName;
}
