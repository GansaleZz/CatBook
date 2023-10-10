package catBook.api.transformer.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import catBook.main.bean.book.BookUserMap;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookUserMapRequestResponseDTOTransformer
        extends BaseRequestResponseDTOTransformer<BookUserMapResponseDTO, BookUserMapRequestDTO, BookUserMap> {

    @Override
    @Mapping(source = "bookTypeID", target = "bookType", qualifiedByName = "bookTypeIDToBookTypeTransformer")
    @Mapping(source = "userID", target = "user", qualifiedByName = "userIDToUserTransformer")
    @Mapping(source = "bookID", target = "book", qualifiedByName = "bookIDToBookTransformer")
    BookUserMap transformRequestDTOToEntity(BookUserMapRequestDTO bookUserMapRequestDTO);

    @Named("bookTypeIDToBookTypeTransformer")
    static BookType bookTypeIDToBookType(long bookTypeID) {
        BookType bookType = new BookType();
        bookType.setID(bookTypeID);

        return bookType;
    }

    @Named("userIDToUserTransformer")
    static User userIDToUser(long userID) {
        User user = new User();
        user.setID(userID);

        return user;
    }

    @Named("bookIDToBookTransformer")
    static Book bookIDToBook(long bookID) {
        Book book = new Book();
        book.setID(bookID);

        return book;
    }
}
