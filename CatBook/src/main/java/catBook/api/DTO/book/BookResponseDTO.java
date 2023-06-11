package catBook.api.DTO.book;

import catBook.api.service.book.BookService;
import genesis.api.BaseReadService;
import genesis.api.GenesisParametersContainer;
import genesis.api.GenesisResponseDTO;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO extends GenesisResponseDTO {

    private String bookName;

    private BookTypeResponseDTO bookType;

    @Override
    protected Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass() {
        return BookService.class;
    }
}
