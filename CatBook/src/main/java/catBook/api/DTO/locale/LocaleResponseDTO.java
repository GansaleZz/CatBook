package catBook.api.DTO.locale;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocaleResponseDTO extends GenesisResponseDTO {

    private String localeName;

    private String localeValue;
}
