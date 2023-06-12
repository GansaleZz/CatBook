package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.api.transformer.notification.container.NotificationStatusParametersContainer;
import catBook.main.bean.notification.NotificationStatus;
import catBook.main.hibernate.criteria.notification.NotificationStatusHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationStatusService extends GenesisReadService<NotificationStatusResponseDTO, NotificationStatus,
        NotificationStatusParametersContainer, NotificationStatusHibernateQueryCriteria> implements NotificationStatusService{
}
