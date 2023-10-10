package catBook.api.transformer.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.main.bean.locale.Locale;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultLocaleDTOTransformer extends GenesisResponseDTOTransformer<LocaleResponseDTO, Locale>
        implements LocaleDTOTransformer {

    @Override
    protected Class<LocaleResponseDTO> getResponseDTOClass() {
        return LocaleResponseDTO.class;
    }

    @Override
    protected void transformCustomData(LocaleResponseDTO localeResponseDTO, Locale locale) {
        localeResponseDTO.setLocaleName(locale.getLocaleName());
        localeResponseDTO.setLocaleValue(locale.getLocaleValue());
    }
}
