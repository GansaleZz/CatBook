package catBook.api.service.notification.validator;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.main.bean.notification.NotificationMessage;
import catBook.main.bean.notification.NotificationStatus;
import catBook.main.bean.notification.NotificationSubType;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Default validator for {@link catBook.api.service.notification.DefaultNotificationService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultNotificationServiceValidator extends GenesisServiceValidator<NotificationRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, NotificationRequestDTO DTO) {
        idValidator.rejectInvalidID(result, DTO.getUserID(), "userID", User.class);
        idValidator.rejectInvalidID(result, DTO.getNotificationMessageID(), "notificationMessageID",
                NotificationMessage.class);
        idValidator.rejectInvalidID(result, DTO.getNotificationStatusID(), "notificationStatusID",
                NotificationStatus.class);
        idValidator.rejectInvalidID(result, DTO.getNotificationSubTypeID(), "notificationSubTypeID",
                NotificationSubType.class);
    }
}
