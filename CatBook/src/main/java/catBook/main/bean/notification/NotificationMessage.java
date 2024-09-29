package catBook.main.bean.notification;

import catBook.main.bean.locale.Locale;
import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Contains data of entity Notification Message.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_NotificationMessage")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessage extends GenesisBean {

    @Column(name = "NotificationMessageValue")
    private String notificationMessageValue;

    @ManyToOne
    @JoinColumn(name = "LocaleID", referencedColumnName = "ID")
    private Locale locale;

    @ManyToOne
    @JoinColumn(name = "NotificationSubTypeID", referencedColumnName = "ID")
    private NotificationSubType notificationSubType;
}
