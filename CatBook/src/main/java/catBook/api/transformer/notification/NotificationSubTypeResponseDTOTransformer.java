package catBook.api.transformer.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.main.bean.notification.NotificationSubType;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationSubTypeResponseDTOTransformer extends BaseResponseDTOTransformer<NotificationSubTypeResponseDTO,
        NotificationSubType> {
}
