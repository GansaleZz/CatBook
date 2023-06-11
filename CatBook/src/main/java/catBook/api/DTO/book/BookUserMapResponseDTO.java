package catBook.api.DTO.book;

import catBook.api.DTO.user.UserResponseDTO;
import catBook.api.service.book.BookUserMapService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserMapResponseDTO extends GenesisResponseDTO {

    private BookResponseDTO book;

    private UserResponseDTO user;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return BookUserMapService.class;
    }
}
