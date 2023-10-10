package catBook.api.DTO.notification;

import catBook.api.service.notification.NotificationSubTypeService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationSubTypeResponseDTO extends GenesisResponseDTO {

    private NotificationTypeResponseDTO notificationType;

    private String notificationSubTypeName;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return NotificationSubTypeService.class;
    }
}
