package catBook.api.DTO.notification;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.api.service.notification.NotificationMessageService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessageResponseDTO extends GenesisResponseDTO {

    private String notificationMessageValue;

    private NotificationTypeResponseDTO notificationType;

    private LocaleResponseDTO locale;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return NotificationMessageService.class;
    }
}
