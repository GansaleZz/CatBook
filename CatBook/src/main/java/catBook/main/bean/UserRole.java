package catBook.main.bean;

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
 * Contains data of role of {@link User}.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_UserRole")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends GenesisBean {

    @Column(name = "UserRoleName")
    private String userRoleName;
}
