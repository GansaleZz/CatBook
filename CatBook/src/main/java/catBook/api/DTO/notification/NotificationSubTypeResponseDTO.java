package catBook.api.DTO.notification;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationSubTypeResponseDTO extends GenesisResponseDTO {

    private NotificationTypeResponseDTO notificationType;

    private String notificationSubTypeName;
}
