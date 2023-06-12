package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.api.transformer.notification.container.NotificationStatusParametersContainer;
import catBook.main.bean.notification.NotificationStatus;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationStatuses")
public interface NotificationStatusService extends BaseReadService<NotificationStatusResponseDTO, NotificationStatus, NotificationStatusParametersContainer> {
}
