package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.transformer.notification.NotificationMessageParametersContainerTransformer;
import catBook.api.transformer.notification.container.NotificationMessageParametersContainer;
import catBook.main.bean.notification.NotificationMessage;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationMessages")
public interface NotificationMessageService extends BaseReadService<NotificationMessageResponseDTO, NotificationMessage, NotificationMessageParametersContainer> {
}
