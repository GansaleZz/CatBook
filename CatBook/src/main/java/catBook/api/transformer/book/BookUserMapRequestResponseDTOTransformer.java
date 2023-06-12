package catBook.api.transformer.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.main.bean.book.BookUserMap;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookUserMapRequestResponseDTOTransformer
        extends BaseRequestResponseDTOTransformer<BookUserMapResponseDTO, BookUserMapRequestDTO, BookUserMap> {
}
