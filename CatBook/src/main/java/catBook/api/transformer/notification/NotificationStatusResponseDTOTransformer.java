package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.main.bean.notification.NotificationStatus;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationStatusResponseDTOTransformer extends BaseResponseDTOTransformer<NotificationStatusResponseDTO,
        NotificationStatus> {
}
