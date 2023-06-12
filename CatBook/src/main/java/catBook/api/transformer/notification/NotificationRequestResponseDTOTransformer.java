package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.main.bean.notification.Notification;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationRequestResponseDTOTransformer extends BaseRequestResponseDTOTransformer<NotificationResponseDTO,
        NotificationRequestDTO, Notification> {
}
