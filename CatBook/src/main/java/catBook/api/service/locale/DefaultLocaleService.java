package catBook.api.service.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.api.transformer.locale.container.LocaleParametersContainer;
import catBook.main.bean.locale.Locale;
import catBook.main.hibernate.criteria.locale.LocaleHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultLocaleService extends GenesisReadService<LocaleResponseDTO, Locale> implements LocaleService {

    @Override
    public CollectionModel<EntityModel<LocaleResponseDTO>> findAll(PageFilter pageFilter, LocaleParametersContainer container) {
        LocaleHibernateQueryCriteria criteria = new LocaleHibernateQueryCriteria();

        if (container.getLocaleName() != null) {
            criteria.setLocaleName(container.getLocaleName());
        }

        if (container.getLocaleValue() != null) {
            criteria.setLocaleValue(container.getLocaleValue());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
