package catBook.main.bean.locale;

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
 * Contains data of entity Locale.
 *
 * @author GansaleZz
 */
@Component
@Entity
@Table(name = "CB_Locale")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Locale extends GenesisBean {

    @Column(name = "LocaleName")
    private String localeName;

    @Column(name = "LocaleValue")
    private String localeValue;
}
