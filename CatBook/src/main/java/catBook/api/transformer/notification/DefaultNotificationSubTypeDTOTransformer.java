package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.main.bean.notification.NotificationSubType;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultNotificationSubTypeDTOTransformer extends GenesisResponseDTOTransformer<NotificationSubTypeResponseDTO, NotificationSubType>
        implements NotificationSubTypeDTOTransformer {

    @Autowired
    private NotificationTypeDTOTransformer notificationTypeDTOTransformer;

    @Override
    protected Class<NotificationSubTypeResponseDTO> getResponseDTOClass() {
        return NotificationSubTypeResponseDTO.class;
    }

    @Override
    protected void transformCustomData(NotificationSubTypeResponseDTO notificationSubTypeResponseDTO, NotificationSubType notificationSubType) {
        notificationSubTypeResponseDTO.setNotificationType(notificationTypeDTOTransformer
                .transformToResponseDTO(notificationSubType.getNotificationType()));
        notificationSubTypeResponseDTO.setNotificationSubTypeName(notificationSubType.getNotificationSubTypeName());
    }
}
