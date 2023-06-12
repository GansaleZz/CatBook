package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.bean.notification.Notification;
import catBook.main.hibernate.criteria.notification.NotificationHibernateQueryCriteria;
import genesis.api.GenesisCreateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationService extends GenesisCreateService<NotificationResponseDTO, NotificationRequestDTO,
        Notification, NotificationParametersContainer, NotificationHibernateQueryCriteria> implements NotificationService {
}
