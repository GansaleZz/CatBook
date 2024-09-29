package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.user.UserDTOTransformer;
import catBook.main.bean.notification.Notification;
import catBook.main.bean.notification.NotificationMessage;
import catBook.main.manager.application.ApplicationSessionHelper;
import catBook.main.manager.notification.NotificationMessageManager;
import catBook.main.manager.token.TokenManager;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultNotificationDTOTransformer extends GenesisResponseDTOTransformer<NotificationResponseDTO, Notification>
        implements NotificationDTOTransformer {

    @Autowired
    private NotificationStatusDTOTransformer notificationStatusDTOTransformer;

    @Autowired
    private NotificationMessageDTOTransformer notificationMessageDTOTransformer;

    @Autowired
    private UserDTOTransformer userDTOTransformer;

    @Autowired
    private NotificationMessageManager notificationMessageManager;

    @Autowired
    private ApplicationSessionHelper applicationSessionHelper;

    @Autowired
    private TokenManager tokenManager;

    @Override
    protected Class<NotificationResponseDTO> getResponseDTOClass() {
        return NotificationResponseDTO.class;
    }

    @Override
    protected void transformCustomData(NotificationResponseDTO notificationResponseDTO, Notification notification) {
        notificationResponseDTO.setNotificationStatus(notificationStatusDTOTransformer
                .transformToResponseDTO(notification.getNotificationStatus()));
        notificationResponseDTO.setUser(userDTOTransformer.transformToResponseDTO(notification.getUser()));
        notificationResponseDTO.setNotificationMessage(transformNotificationMessageWithProcessedToken(notification
                .getNotificationSubType().getID()));
    }

    private NotificationMessageResponseDTO transformNotificationMessageWithProcessedToken(long notificationSubTypeID) {
        NotificationMessage notificationMessage = notificationMessageManager
                .findByNotificationSubTypeIDAndLocaleID(notificationSubTypeID, applicationSessionHelper.getLocale().getID());
        notificationMessage.setNotificationMessageValue(tokenManager.processToken(notificationMessage
                .getNotificationMessageValue()));

        return notificationMessageDTOTransformer.transformToResponseDTO(notificationMessage);
    }
}
