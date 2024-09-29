package catBook.api.DTO.notification;

import catBook.api.DTO.user.UserResponseDTO;
import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResponseDTO extends GenesisResponseDTO {

    private NotificationStatusResponseDTO notificationStatus;

    private UserResponseDTO user;

    private NotificationMessageResponseDTO notificationMessage;
}
