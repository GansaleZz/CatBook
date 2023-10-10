package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.bean.notification.Notification;
import catBook.main.hibernate.criteria.notification.NotificationHibernateQueryCriteria;
import catBook.main.hibernate.criteria.notification.NotificationMessageHibernateQueryCriteria;
import catBook.main.manager.application.ApplicationSessionHelper;
import catBook.main.manager.notification.NotificationMessageManager;
import catBook.main.manager.token.TokenManager;
import genesis.api.GenesisCreateService;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultNotificationService extends GenesisCreateService<NotificationResponseDTO, NotificationRequestDTO,
        Notification, NotificationParametersContainer, NotificationHibernateQueryCriteria> implements NotificationService {

    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private NotificationMessageService notificationMessageService;
    @Autowired
    private NotificationMessageManager notificationMessageManager;
    @Autowired
    private ApplicationSessionHelper applicationSessionHelper;

    @Override
    public CollectionModel<EntityModel<NotificationResponseDTO>> findAll(PageFilter pageFilter, NotificationParametersContainer container, BindingResult bindingResult) {
        CollectionModel<EntityModel<NotificationResponseDTO>> notifications = super.findAll(pageFilter, container, bindingResult);
        notifications.getContent().stream()
                .map(EntityModel::getContent)
                .forEach(notification -> {
                    notification.setNotificationMessage(populateNotificationMessage(notification));

                    notification.getNotificationMessage().setNotificationMessageValue(
                                tokenManager.processToken(notification.getNotificationMessage().getNotificationMessageValue()));
                });

        return notifications;
    }

    @Override
    public EntityModel<NotificationResponseDTO> findByID(long ID) {
        EntityModel<NotificationResponseDTO> notification =  super.findByID(ID);

        notification.getContent().setNotificationMessage(populateNotificationMessage(notification.getContent()));
        notification.getContent().getNotificationMessage().setNotificationMessageValue(
                tokenManager.processToken(notification.getContent()
                        .getNotificationMessage().getNotificationMessageValue()));

        return notification;
    }

    private NotificationMessageResponseDTO populateNotificationMessage(NotificationResponseDTO notification) {
        NotificationMessageHibernateQueryCriteria criteria = new NotificationMessageHibernateQueryCriteria();
        criteria.setNotificationSubTypeID(notification.getNotificationSubType().getID());
        criteria.setLocaleID(applicationSessionHelper.getLocale().getID());

        return notificationMessageService.findByID(
                notificationMessageManager.findSingleByCriteria(criteria).getID()).getContent();
    }
}
