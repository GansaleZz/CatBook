package catBook.api.transformer.notification.container;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationParametersContainer extends GenesisParametersContainer {

    private long notificationTypeID = GenesisConstants.EMPTY_LONG;

    private long notificationStatusID = GenesisConstants.EMPTY_LONG;

    private long userID = GenesisConstants.EMPTY_LONG;
}
