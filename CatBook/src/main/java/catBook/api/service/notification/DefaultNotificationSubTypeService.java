package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationSubTypeParametersContainer;
import catBook.main.bean.notification.NotificationSubType;
import catBook.main.hibernate.criteria.notification.NotificationSubTypeHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationSubTypeService extends GenesisReadService<NotificationSubTypeResponseDTO,
        NotificationSubType> implements NotificationSubTypeService {

    @Override
    public CollectionModel<EntityModel<NotificationSubTypeResponseDTO>> findAll(PageFilter pageFilter, NotificationSubTypeParametersContainer container) {
        NotificationSubTypeHibernateQueryCriteria criteria = new NotificationSubTypeHibernateQueryCriteria();

        if (container.getNotificationSubTypeName() != null) {
            criteria.setNotificationSubTypeName(container.getNotificationSubTypeName());
        }

        if (container.getNotificationTypeID() != GenesisConstants.EMPTY_LONG) {
            criteria.setNotificationTypeID(container.getNotificationTypeID());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
