package catBook.main.bean.user;

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
 * Contains data of relations between {@link User} and {@link UserRole}.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_UserRoleMap")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleMap extends GenesisBean {

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "UserRoleID", referencedColumnName = "ID")
    private UserRole userRole;
}
