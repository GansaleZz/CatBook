package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.main.bean.notification.NotificationStatus;
import genesis.api.BaseResponseDTOTransformer;

public interface NotificationStatusDTOTransformer extends BaseResponseDTOTransformer<NotificationStatusResponseDTO,
        NotificationStatus> {
}
