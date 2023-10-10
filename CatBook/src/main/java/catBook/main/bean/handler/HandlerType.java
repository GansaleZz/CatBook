package catBook.main.bean.handler;

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
 * Contains data of entity Handler Type.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_HandlerType")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HandlerType extends GenesisBean {

    @Column(name = "HandlerTypeName")
    private String handlerTypeName;
}
