package catBook.api.service.book.validator;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.util.validator.IDValidator;
import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Default validator for {@link catBook.api.service.book.DefaultBookUserMapService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultBookUserMapServiceValidator extends GenesisServiceValidator<BookUserMapRequestDTO> {

    @Override
    public void doValidate(BaseRequestResult result, BookUserMapRequestDTO DTO) {
        idValidator.rejectInvalidID(result, DTO.getBookID(), "bookID", Book.class);
        idValidator.rejectInvalidID(result, DTO.getUserID(), "userID", User.class);
        idValidator.rejectInvalidID(result, DTO.getBookTypeID(), "bookTypeID", BookType.class);
    }
}
