package catBook.api.DTO.notification;

import catBook.api.DTO.locale.LocaleResponseDTO;
import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessageResponseDTO extends GenesisResponseDTO {

    private String notificationMessageValue;

    private NotificationSubTypeResponseDTO notificationSubType;

    private LocaleResponseDTO locale;
}
