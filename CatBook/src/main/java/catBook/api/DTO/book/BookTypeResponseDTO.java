package catBook.api.DTO.book;

import catBook.api.service.book.BookTypeService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTypeResponseDTO extends GenesisResponseDTO {

    private String bookTypeName;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return BookTypeService.class;
    }
}
