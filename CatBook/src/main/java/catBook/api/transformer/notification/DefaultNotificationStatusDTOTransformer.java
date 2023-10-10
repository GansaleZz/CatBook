package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.main.bean.notification.NotificationStatus;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultNotificationStatusDTOTransformer extends GenesisResponseDTOTransformer<NotificationStatusResponseDTO, NotificationStatus>
        implements NotificationStatusDTOTransformer {

    @Override
    protected Class<NotificationStatusResponseDTO> getResponseDTOClass() {
        return NotificationStatusResponseDTO.class;
    }

    @Override
    protected void transformCustomData(NotificationStatusResponseDTO notificationStatusResponseDTO, NotificationStatus notificationStatus) {
        notificationStatusResponseDTO.setNotificationStatusName(notificationStatus.getNotificationStatusName());
    }
}
