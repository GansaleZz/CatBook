package catBook.api.transformer.book;

import catBook.api.DTO.book.BookResponseDTO;
import catBook.main.bean.book.Book;
import genesis.api.BaseResponseDTOTransformer;

public interface BookDTOTransformer extends BaseResponseDTOTransformer<BookResponseDTO, Book> {
}
