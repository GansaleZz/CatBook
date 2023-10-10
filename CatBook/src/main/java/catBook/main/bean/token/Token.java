package catBook.main.bean.token;

import catBook.main.bean.handler.Handler;
import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Contains data of entity Token.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_Token")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token extends GenesisBean {

    @Column(name = "TokenName")
    private String tokenName;

    @Column(name = "TokenValue")
    private String tokenValue;

    @ManyToOne
    @JoinColumn(name = "HandlerID", referencedColumnName = "ID")
    private Handler handler;
}
