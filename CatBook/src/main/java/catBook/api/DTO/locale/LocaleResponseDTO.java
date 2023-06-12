package catBook.api.DTO.locale;

import catBook.api.service.locale.LocaleService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocaleResponseDTO extends GenesisResponseDTO {

    private String localeName;

    private String localeValue;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return LocaleService.class;
    }
}
