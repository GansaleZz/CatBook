package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.transformer.notification.container.NotificationMessageParametersContainer;
import catBook.main.bean.notification.NotificationMessage;
import catBook.main.hibernate.criteria.notification.NotificationMessageHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationMessageService extends GenesisReadService<NotificationMessageResponseDTO, NotificationMessage,
        NotificationMessageParametersContainer, NotificationMessageHibernateQueryCriteria> implements NotificationMessageService {
}
