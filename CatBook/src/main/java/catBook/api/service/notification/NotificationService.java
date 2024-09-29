package catBook.api.service.notification;

import catBook.api.DTO.notification.NotificationRequestDTO;
import catBook.api.DTO.notification.NotificationResponseDTO;
import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.bean.notification.Notification;
import genesis.api.BaseCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/notifications")
public interface NotificationService extends BaseCreateService<NotificationResponseDTO, Notification, NotificationRequestDTO> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<NotificationResponseDTO>> findAll(PageFilter pageFilter,
                                                            NotificationParametersContainer container);
}
