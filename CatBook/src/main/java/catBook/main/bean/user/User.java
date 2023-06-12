package catBook.main.bean.user;

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
 * Contains data of entity User.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_User")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends GenesisBean {

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;
}
