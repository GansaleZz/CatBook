package catBook.api.transformer.book;

import catBook.api.DTO.book.BookResponseDTO;
import catBook.main.bean.book.Book;
import genesis.api.GenesisResponseDTOTransformer;
import org.springframework.stereotype.Component;

@Component
public class DefaultBookDTOTransformer extends GenesisResponseDTOTransformer<BookResponseDTO, Book>
        implements BookDTOTransformer {

    @Override
    protected Class<BookResponseDTO> getResponseDTOClass() {
        return BookResponseDTO.class;
    }

    @Override
    protected void transformCustomData(BookResponseDTO bookResponseDTO, Book book) {
        bookResponseDTO.setBookName(book.getBookName());
    }
}
