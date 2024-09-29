package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationStatusResponseDTO;
import catBook.api.transformer.notification.container.NotificationStatusParametersContainer;
import catBook.main.bean.notification.NotificationStatus;
import catBook.main.hibernate.criteria.notification.NotificationStatusHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationStatusService extends GenesisReadService<NotificationStatusResponseDTO, NotificationStatus>
        implements NotificationStatusService {

    @Override
    public CollectionModel<EntityModel<NotificationStatusResponseDTO>> findAll(PageFilter pageFilter, NotificationStatusParametersContainer container) {
        NotificationStatusHibernateQueryCriteria criteria = new NotificationStatusHibernateQueryCriteria();

        if (container.getNotificationStatusName() != null) {
            criteria.setNotificationStatusName(container.getNotificationStatusName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
