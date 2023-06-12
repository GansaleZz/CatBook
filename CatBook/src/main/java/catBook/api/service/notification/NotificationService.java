package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.bean.notification.Notification;
import genesis.api.BaseCreateService;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notifications")
public interface NotificationService extends BaseCreateService<NotificationResponseDTO, NotificationRequestDTO>,
        BaseReadService<NotificationResponseDTO, Notification, NotificationParametersContainer> {
}
