package catBook.api.transformer.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookRequestResponseDTOTransformer extends BaseRequestResponseDTOTransformer<BookResponseDTO, BookRequestDTO, Book> {

}
