package catBook.api.transformer.notification.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationSubTypeParametersContainer extends GenesisParametersContainer {

    private String notificationSubTypeName = null;

    private Long notificationTypeID = GenesisConstants.EMPTY_LONG;
}
