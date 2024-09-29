package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.bean.notification.Notification;
import catBook.main.hibernate.criteria.notification.NotificationHibernateQueryCriteria;
import catBook.main.manager.notification.NotificationStatusManager;
import catBook.main.manager.notification.NotificationSubTypeManager;
import catBook.main.manager.user.UserManager;
import genesis.api.GenesisCreateService;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationService extends GenesisCreateService<NotificationResponseDTO, Notification,
        NotificationRequestDTO> implements NotificationService {

    @Autowired
    private NotificationStatusManager notificationStatusManager;

    @Autowired
    private NotificationSubTypeManager notificationSubTypeManager;

    @Autowired
    private UserManager userManager;

    @Override
    public CollectionModel<EntityModel<NotificationResponseDTO>> findAll(PageFilter pageFilter, NotificationParametersContainer container) {
        NotificationHibernateQueryCriteria criteria = new NotificationHibernateQueryCriteria();

        if (container.getNotificationStatusID() != GenesisConstants.EMPTY_LONG) {
            criteria.setNotificationStatusID(container.getNotificationStatusID());
        }

        if (container.getNotificationSubTypeID() != GenesisConstants.EMPTY_LONG) {
            criteria.setNotificationSubTypeID(container.getNotificationSubTypeID());
        }

        if (container.getUserID() != GenesisConstants.EMPTY_LONG) {
            criteria.setUserID(container.getUserID());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }

    @Override
    protected Notification doSave(NotificationRequestDTO notificationRequestDTO) {
        Notification notification = new Notification();
        notification.setNotificationStatus(notificationStatusManager.findByID(notificationRequestDTO.getNotificationStatusID()));
        notification.setNotificationSubType(notificationSubTypeManager.findByID(notificationRequestDTO.getNotificationSubTypeID()));
        notification.setUser(userManager.findByID(notificationRequestDTO.getUserID()));

        return notification;
    }
}
