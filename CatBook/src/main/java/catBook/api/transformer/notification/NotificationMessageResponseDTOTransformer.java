package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.main.bean.notification.NotificationMessage;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMessageResponseDTOTransformer extends BaseResponseDTOTransformer<NotificationMessageResponseDTO,
        NotificationMessage> {
}
