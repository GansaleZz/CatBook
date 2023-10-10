package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationSubTypeParametersContainer;
import catBook.main.bean.notification.NotificationSubType;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationSubTypes")
public interface NotificationSubTypeService extends BaseReadService<NotificationSubTypeResponseDTO,
        NotificationSubType, NotificationSubTypeParametersContainer> {
}
