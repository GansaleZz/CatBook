package catBook.api.service.book.validator;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.service.book.DefaultBookUserMapService;
import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

/**
 * Default validator for {@link DefaultBookUserMapService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultBookUserMapServiceValidator extends GenesisServiceValidator<BookUserMapRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, BookUserMapRequestDTO bookUserMapRequestDTO) {
        idValidator.rejectInvalidID(result, bookUserMapRequestDTO.getBookID(), "bookID", Book.class);
        idValidator.rejectInvalidID(result, bookUserMapRequestDTO.getUserID(), "userID", User.class);
        idValidator.rejectInvalidID(result, bookUserMapRequestDTO.getBookTypeID(), "bookTypeID", BookType.class);
    }
}
