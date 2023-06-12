package catBook.api.transformer.notification.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTypeParametersContainer extends GenesisParametersContainer {

    private String notificationTypeName;
}
