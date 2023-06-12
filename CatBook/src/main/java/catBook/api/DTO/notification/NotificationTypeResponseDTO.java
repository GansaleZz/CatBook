package catBook.api.DTO.notification;

import catBook.api.service.notification.NotificationTypeService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTypeResponseDTO extends GenesisResponseDTO {

    private String notificationTypeName;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return NotificationTypeService.class;
    }
}
