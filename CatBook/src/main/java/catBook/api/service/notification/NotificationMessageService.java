package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationMessageResponseDTO;
import catBook.api.transformer.notification.container.NotificationMessageParametersContainer;
import catBook.main.bean.notification.NotificationMessage;
import genesis.api.BaseReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationMessages")
public interface NotificationMessageService extends BaseReadService<NotificationMessageResponseDTO, NotificationMessage> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<NotificationMessageResponseDTO>> findAll(PageFilter pageFilter,
                                                                  NotificationMessageParametersContainer container);
}
