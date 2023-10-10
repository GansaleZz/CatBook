package catBook.api.util.validator;

import genesis.api.BaseRequestResult;
import genesis.util.constant.GenesisConstants;
import genesis.util.validation.GenesisValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DateValidator extends GenesisValidator {

    public void rejectEmpty(BaseRequestResult result, String fieldName, LocalDateTime fieldValue) {
        if (Optional.ofNullable(fieldValue).isEmpty() || fieldValue.equals(GenesisConstants.EMPTY_DATE)) {
            putError(fieldName, String.format(GenesisConstants.VALIDATION_EMPTY_FIELD, fieldName), result);
        }
    }
}
