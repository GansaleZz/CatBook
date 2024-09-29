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
 * Contains data of entity Notification Status.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_NotificationStatus")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationStatus extends GenesisBean {

    @Column(name = "NotificationStatusName")
    private String notificationStatusName;
}
