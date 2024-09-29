package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.main.bean.notification.NotificationMessage;
import genesis.api.BaseResponseDTOTransformer;

public interface NotificationMessageDTOTransformer extends BaseResponseDTOTransformer<NotificationMessageResponseDTO,
        NotificationMessage> {
}
