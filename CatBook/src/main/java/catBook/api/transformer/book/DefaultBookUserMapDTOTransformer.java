package catBook.api.transformer.book;

import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.api.transformer.user.UserDTOTransformer;
import catBook.main.bean.book.BookUserMap;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBookUserMapDTOTransformer extends GenesisResponseDTOTransformer<BookUserMapResponseDTO, BookUserMap>
        implements BookUserMapDTOTransformer {

    @Autowired
    private BookDTOTransformer bookDTOTransformer;

    @Autowired
    private BookTypeDTOTransformer bookTypeDTOTransformer;

    @Autowired
    private UserDTOTransformer userDTOTransformer;

    @Override
    protected Class<BookUserMapResponseDTO> getResponseDTOClass() {
        return BookUserMapResponseDTO.class;
    }

    @Override
    protected void transformCustomData(BookUserMapResponseDTO bookUserMapResponseDTO, BookUserMap bookUserMap) {
        bookUserMapResponseDTO.setBookType(bookTypeDTOTransformer.transformToResponseDTO(bookUserMap.getBookType()));
        bookUserMapResponseDTO.setBook(bookDTOTransformer.transformToResponseDTO(bookUserMap.getBook()));
        bookUserMapResponseDTO.setUser(userDTOTransformer.transformToResponseDTO(bookUserMap.getUser()));
    }
}
