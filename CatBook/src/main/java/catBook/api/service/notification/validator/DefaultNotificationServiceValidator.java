package catBook.api.service.notification.validator;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.service.notification.DefaultNotificationService;
import catBook.main.bean.notification.NotificationStatus;
import catBook.main.bean.notification.NotificationSubType;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

/**
 * Default validator for {@link DefaultNotificationService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultNotificationServiceValidator extends GenesisServiceValidator<NotificationRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, NotificationRequestDTO notificationRequestDTO) {
        idValidator.rejectInvalidID(result, notificationRequestDTO.getUserID(), "userID", User.class);
        idValidator.rejectInvalidID(result, notificationRequestDTO.getNotificationStatusID(), "notificationStatusID",
                NotificationStatus.class);
        idValidator.rejectInvalidID(result, notificationRequestDTO.getNotificationSubTypeID(), "notificationSubTypeID",
                NotificationSubType.class);
    }
}
