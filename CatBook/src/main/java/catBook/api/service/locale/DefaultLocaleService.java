package catBook.api.service.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.api.transformer.locale.container.LocaleParametersContainer;
import catBook.main.bean.locale.Locale;
import catBook.main.hibernate.criteria.locale.LocaleHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultLocaleService extends GenesisReadService<LocaleResponseDTO, Locale, LocaleParametersContainer, LocaleHibernateQueryCriteria>
        implements LocaleService {
}
