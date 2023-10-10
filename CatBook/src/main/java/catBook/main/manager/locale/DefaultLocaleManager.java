package catBook.main.manager.locale;

import catBook.main.bean.locale.Locale;
import catBook.main.hibernate.DAO.locale.LocaleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLocaleManager extends LocaleManager {

    @Autowired
    private LocaleDAO localeDAO;

    @Override
    public Locale findByLocaleName(String localeName) {
        return localeDAO.findByLocaleName(localeName);
    }
}
