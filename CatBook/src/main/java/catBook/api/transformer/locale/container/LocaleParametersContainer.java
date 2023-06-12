package catBook.api.transformer.locale.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocaleParametersContainer extends GenesisParametersContainer {

    private String localeName;

    private String localeValue;
}
