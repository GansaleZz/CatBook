package catBook.main.bean.book;

import catBook.main.bean.user.User;
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
 * Contains data of relations between {@link User} and {@link Book}.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_BookUserMap")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookUserMap extends GenesisBean {

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "BookTypeID", referencedColumnName = "ID")
    private BookType bookType;
}
