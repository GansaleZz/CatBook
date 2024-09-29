package catBook.api.transformer.notification.container;

import genesis.api.GenesisParametersContainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationStatusParametersContainer extends GenesisParametersContainer {

    private String notificationStatusName;
}
