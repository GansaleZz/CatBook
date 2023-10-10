package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.main.bean.notification.Notification;
import genesis.api.BaseResponseDTOTransformer;

public interface NotificationDTOTransformer extends BaseResponseDTOTransformer<NotificationResponseDTO, Notification> {
}
