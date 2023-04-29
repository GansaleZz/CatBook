package catBook.api.transformer.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.main.bean.Book;
import catBook.main.bean.BookType;
import genesis.api.BaseRequestResponseTransformerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookRequestResponseTransformerDTO extends BaseRequestResponseTransformerDTO<BookResponseDTO, BookRequestDTO, Book> {

    @Override
    @Mapping(source = "bookTypeID", target = "bookType", qualifiedByName = "bookTypeIDToBookTypeTransformer")
    Book transformRequestDTOToEntity(BookRequestDTO bookRequestDTO);

    @Named("bookTypeIDToBookTypeTransformer")
    static BookType bookTypeIDToBookType(long bookTypeID) {
        BookType bookType = new BookType();
        bookType.setID(bookTypeID);

        return bookType;
    }
}
