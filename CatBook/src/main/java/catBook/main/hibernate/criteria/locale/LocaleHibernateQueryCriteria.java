package catBook.main.hibernate.criteria.locale;

import catBook.main.bean.locale.Locale;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocaleHibernateQueryCriteria extends GenesisHibernateQueryCriteria<Locale> {

    @Override
    public Class<Locale> getBeanClass() {
        return Locale.class;
    }

    @Criteria(name = "localeName")
    private String localeName = null;

    @Criteria(name = "localeValue")
    private String localeValue = null;
}
