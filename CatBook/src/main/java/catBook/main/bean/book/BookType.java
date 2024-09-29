package catBook.main.bean.book;

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
 * Contains data of type of {@link Book}.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_BookType")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookType extends GenesisBean {

    @Column(name = "BookTypeName")
    private String bookTypeName;
}
