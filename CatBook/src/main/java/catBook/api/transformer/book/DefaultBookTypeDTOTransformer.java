package catBook.api.transformer.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.main.bean.book.BookType;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultBookTypeDTOTransformer extends GenesisResponseDTOTransformer<BookTypeResponseDTO, BookType>
        implements BookTypeDTOTransformer {

    @Override
    protected Class<BookTypeResponseDTO> getResponseDTOClass() {
        return BookTypeResponseDTO.class;
    }

    @Override
    protected void transformCustomData(BookTypeResponseDTO bookTypeResponseDTO, BookType bookType) {
        bookTypeResponseDTO.setBookTypeName(bookType.getBookTypeName());
    }
}
