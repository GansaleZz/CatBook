package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.main.bean.notification.NotificationType;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationTypeResponseDTOTransformer extends BaseResponseDTOTransformer<NotificationTypeResponseDTO,
        NotificationType> {
}
