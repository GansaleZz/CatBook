package catBook.api.DTO.notification;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDTO extends GenesisRequestDTO {

    private Long notificationSubTypeID;

    private Long notificationStatusID;

    private Long userID;
}
