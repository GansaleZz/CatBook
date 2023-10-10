package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.main.bean.notification.NotificationType;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultNotificationTypeDTOTransformer extends GenesisResponseDTOTransformer<NotificationTypeResponseDTO, NotificationType>
        implements NotificationTypeDTOTransformer {

    @Override
    protected Class<NotificationTypeResponseDTO> getResponseDTOClass() {
        return NotificationTypeResponseDTO.class;
    }

    @Override
    protected void transformCustomData(NotificationTypeResponseDTO notificationTypeResponseDTO, NotificationType notificationType) {
        notificationTypeResponseDTO.setNotificationTypeName(notificationType.getNotificationTypeName());
    }
}
