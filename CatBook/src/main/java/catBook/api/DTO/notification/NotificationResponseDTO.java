package catBook.api.DTO.notification;

import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.service.notification.NotificationService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResponseDTO extends GenesisResponseDTO {

    private NotificationTypeResponseDTO notificationType;

    private NotificationStatusResponseDTO notificationStatus;

    private UserResponseDTO user;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return NotificationService.class;
    }
}
