package catBook.api.transformer.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.main.bean.BookType;
import genesis.api.BaseResponseTransformerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookTypeResponseTransformerDTO extends BaseResponseTransformerDTO<BookTypeResponseDTO, BookType> {
}
