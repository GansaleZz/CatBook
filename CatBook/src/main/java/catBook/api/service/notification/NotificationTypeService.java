package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationTypeParametersContainer;
import catBook.main.bean.notification.NotificationType;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationTypes")
public interface NotificationTypeService extends BaseReadService<NotificationTypeResponseDTO, NotificationType, NotificationTypeParametersContainer> {
}