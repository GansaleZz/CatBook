package catBook.api.util.validator;

import genesis.api.BaseRequestResult;
import genesis.util.constant.GenesisConstants;
import genesis.util.validation.GenesisValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringValidator extends GenesisValidator {

    public void rejectBlank(BaseRequestResult result, String fieldName, String fieldValue) {
        if (Optional.ofNullable(fieldValue).isEmpty() || fieldValue.trim().isEmpty()) {
            putError(fieldName, String.format(GenesisConstants.VALIDATION_EMPTY_FIELD, fieldName), result);
        }
    }

    public void rejectTooLong(BaseRequestResult result, String fieldName, String fieldValue, int maxChars) {
        if (Optional.ofNullable(fieldValue).isPresent() && fieldValue.toCharArray().length > maxChars) {
            putError(fieldName, String.format(GenesisConstants.VALIDATION_STRING_TOO_LONG, fieldName, maxChars), result);
        }
    }

}
