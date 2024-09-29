package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationTypeParametersContainer;
import catBook.main.bean.notification.NotificationType;
import catBook.main.hibernate.criteria.notification.NotificationTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationTypeService extends GenesisReadService<NotificationTypeResponseDTO, NotificationType>
        implements NotificationTypeService {

    @Override
    public CollectionModel<EntityModel<NotificationTypeResponseDTO>> findAll(PageFilter pageFilter, NotificationTypeParametersContainer container) {
        NotificationTypeHibernateQueryCriteria criteria = new NotificationTypeHibernateQueryCriteria();

        if (container.getNotificationTypeName() != null) {
            criteria.setNotificationTypeName(container.getNotificationTypeName());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
