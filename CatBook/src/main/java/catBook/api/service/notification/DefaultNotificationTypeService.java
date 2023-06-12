package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationTypeParametersContainer;
import catBook.main.bean.notification.NotificationType;
import catBook.main.hibernate.criteria.notification.NotificationTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationTypeService extends GenesisReadService<NotificationTypeResponseDTO, NotificationType,
        NotificationTypeParametersContainer, NotificationTypeHibernateQueryCriteria> implements NotificationTypeService {
}
