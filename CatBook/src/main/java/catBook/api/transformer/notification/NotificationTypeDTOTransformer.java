package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.main.bean.notification.NotificationType;
import genesis.api.BaseResponseDTOTransformer;

public interface NotificationTypeDTOTransformer extends BaseResponseDTOTransformer<NotificationTypeResponseDTO,
        NotificationType> {
}
