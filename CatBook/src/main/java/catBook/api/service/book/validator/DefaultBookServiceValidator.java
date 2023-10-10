package catBook.api.service.book.validator;

import catBook.api.DTO.book.BookRequestDTO;
import genesis.api.BaseRequestResult;
import genesis.api.GenesisServiceValidator;
import org.springframework.stereotype.Component;

/**
 * Default validator for {@link catBook.api.service.book.DefaultBookService}.
 *
 * @author GansaleZz
 */
@Component
public class DefaultBookServiceValidator extends GenesisServiceValidator<BookRequestDTO> {

    private static final int MAX_BOOK_NAME_LENGTH = 100;

    @Override
    public void doValidate(BaseRequestResult result, BookRequestDTO DTO) {
        String bookName = DTO.getBookName();
        stringValidator.rejectBlank(result, "bookName", bookName);
        stringValidator.rejectTooLong(result, "bookName", bookName, MAX_BOOK_NAME_LENGTH);
    }
}
