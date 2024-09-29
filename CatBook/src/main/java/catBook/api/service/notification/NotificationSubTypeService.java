package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationSubTypeResponseDTO;
import catBook.api.transformer.notification.container.NotificationSubTypeParametersContainer;
import catBook.main.bean.notification.NotificationSubType;
import genesis.api.BaseReadService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notificationSubTypes")
public interface NotificationSubTypeService extends BaseReadService<NotificationSubTypeResponseDTO, NotificationSubType> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<NotificationSubTypeResponseDTO>> findAll(PageFilter pageFilter,
                                                                  NotificationSubTypeParametersContainer container);
}
