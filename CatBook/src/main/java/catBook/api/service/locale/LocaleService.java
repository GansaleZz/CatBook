package catBook.api.service.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.api.transformer.locale.container.LocaleParametersContainer;
import catBook.main.bean.locale.Locale;
import genesis.api.BaseReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/locales")
public interface LocaleService extends BaseReadService<LocaleResponseDTO, Locale> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<LocaleResponseDTO>> findAll(PageFilter pageFilter,
                                                          LocaleParametersContainer container);
}
