package catBook.api.DTO.notification;

import catBook.api.service.notification.NotificationStatusService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationStatusResponseDTO extends GenesisResponseDTO {

    private String notificationStatusName;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return NotificationStatusService.class;
    }
}
