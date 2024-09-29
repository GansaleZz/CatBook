package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.transformer.locale.LocaleDTOTransformer;
import catBook.main.bean.notification.NotificationMessage;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultNotificationMessageDTOTransformer extends GenesisResponseDTOTransformer<NotificationMessageResponseDTO, NotificationMessage>
        implements NotificationMessageDTOTransformer {

    @Autowired
    private LocaleDTOTransformer localeDTOTransformer;

    @Autowired
    private NotificationSubTypeDTOTransformer notificationSubTypeDTOTransformer;

    @Override
    protected Class<NotificationMessageResponseDTO> getResponseDTOClass() {
        return NotificationMessageResponseDTO.class;
    }

    @Override
    protected void transformCustomData(NotificationMessageResponseDTO notificationMessageResponseDTO, NotificationMessage notificationMessage) {
        notificationMessageResponseDTO.setNotificationMessageValue(notificationMessage.getNotificationMessageValue());
        notificationMessageResponseDTO.setNotificationSubType(notificationSubTypeDTOTransformer
                .transformToResponseDTO(notificationMessage.getNotificationSubType()));
        notificationMessageResponseDTO.setLocale(localeDTOTransformer.transformToResponseDTO(notificationMessage.getLocale()));
    }
}
