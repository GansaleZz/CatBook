package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.transformer.notification.container.NotificationMessageParametersContainer;
import catBook.main.bean.notification.NotificationMessage;
import catBook.main.hibernate.criteria.notification.NotificationMessageHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationMessageService extends GenesisReadService<NotificationMessageResponseDTO, NotificationMessage>
        implements NotificationMessageService {

    @Override
    public CollectionModel<EntityModel<NotificationMessageResponseDTO>> findAll(PageFilter pageFilter, NotificationMessageParametersContainer container) {
        NotificationMessageHibernateQueryCriteria criteria = new NotificationMessageHibernateQueryCriteria();

        if (container.getNotificationSubTypeID() != GenesisConstants.EMPTY_LONG) {
            criteria.setNotificationSubTypeID(container.getNotificationSubTypeID());
        }

        if (container.getNotificationMessageValue() != null) {
            criteria.setNotificationMessageValue(container.getNotificationMessageValue());
        }

        if (container.getLocaleID() != GenesisConstants.EMPTY_LONG) {
            criteria.setLocaleID(container.getLocaleID());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }
}
