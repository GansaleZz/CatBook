package catBook.api.transformer.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.main.bean.BookUserMap;
import genesis.api.BaseRequestResponseTransformerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookUserMapResponseTransformerDTO
        extends BaseRequestResponseTransformerDTO<BookUserMapResponseDTO, BookUserMapRequestDTO, BookUserMap> {
}
