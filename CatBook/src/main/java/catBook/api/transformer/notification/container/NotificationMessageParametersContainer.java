package catBook.api.transformer.notification.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessageParametersContainer extends GenesisParametersContainer {

    private String notificationMessageValue;

    private long localeID = GenesisConstants.EMPTY_LONG;

    private long notificationSubTypeID = GenesisConstants.EMPTY_LONG;
}
