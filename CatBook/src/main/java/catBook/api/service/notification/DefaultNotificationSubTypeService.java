package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationSubTypeParametersContainer;
import catBook.main.bean.notification.NotificationSubType;
import catBook.main.hibernate.criteria.notification.NotificationSubTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationSubTypeService extends GenesisReadService<NotificationSubTypeResponseDTO,
        NotificationSubType, NotificationSubTypeParametersContainer, NotificationSubTypeHibernateQueryCriteria>
        implements NotificationSubTypeService {
}
