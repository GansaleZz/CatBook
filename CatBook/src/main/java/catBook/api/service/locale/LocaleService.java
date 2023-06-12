package catBook.api.service.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.api.transformer.locale.container.LocaleParametersContainer;
import catBook.main.bean.locale.Locale;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/locales")
public interface LocaleService extends BaseReadService<LocaleResponseDTO, Locale, LocaleParametersContainer> {
}
