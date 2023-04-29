package catBook.main.bean;

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
 * Contains data about entity Book.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_Book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends GenesisBean {

    @Column(name = "BookName")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "BookTypeID", referencedColumnName = "ID")
    private BookType bookType;
}
