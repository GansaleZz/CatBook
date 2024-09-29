package catBook.main.bean.handler;

import genesis.bean.GenesisBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Contains data of entity Handler.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_Handler")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Handler extends GenesisBean {

    @Column(name = "HandlerName")
    private String handlerName;

    @ManyToOne
    @JoinColumn(name = "HandlerTypeID", referencedColumnName = "ID")
    private HandlerType handlerType;
}
