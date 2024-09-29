package catBook.api.DTO.notification;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationStatusResponseDTO extends GenesisResponseDTO {

    private String notificationStatusName;
}
