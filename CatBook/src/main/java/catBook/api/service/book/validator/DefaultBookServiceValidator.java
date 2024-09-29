package catBook.api.service.book.validator;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.service.book.DefaultBookService;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

/**
 * Default validator for {@link DefaultBookService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultBookServiceValidator extends GenesisServiceValidator<BookRequestDTO> {

    private static final int MAX_BOOK_NAME_LENGTH = 100;

    @Override
    public void doValidate(BaseRequestResult result, BookRequestDTO bookRequestDTO) {
        String bookName = bookRequestDTO.getBookName();
        stringValidator.rejectBlank(result, "bookName", bookName);
        stringValidator.rejectTooLong(result, "bookName", bookName, MAX_BOOK_NAME_LENGTH);
    }
}
