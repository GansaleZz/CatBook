package catBook.api.util.validator;

import genesis.api.BaseRequestResult;
import genesis.util.constant.GenesisConstants;
import genesis.util.validation.GenesisValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LongValidator extends GenesisValidator {

    public void rejectEmpty(BaseRequestResult result, Long fieldValue, String fieldName) {
        if (Optional.ofNullable(fieldValue).isEmpty() || fieldValue.equals(GenesisConstants.EMPTY_LONG)) {
            putError(fieldName, String.format(GenesisConstants.VALIDATION_EMPTY_FIELD, fieldName), result);
        }
    }
}
