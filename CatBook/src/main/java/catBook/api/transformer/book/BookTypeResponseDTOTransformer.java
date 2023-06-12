package catBook.api.transformer.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.main.bean.book.BookType;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookTypeResponseDTOTransformer extends BaseResponseDTOTransformer<BookTypeResponseDTO, BookType> {
}
