package catBook.api.DTO.notification;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDTO extends GenesisRequestDTO {

    private long notificationTypeID;

    private long notificationStatusID;

    private long userID;
}
