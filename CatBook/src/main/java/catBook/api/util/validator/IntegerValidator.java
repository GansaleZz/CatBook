package catBook.api.util.validator;

import genesis.api.BaseRequestResult;
import genesis.util.constant.GenesisConstants;
import genesis.util.validation.GenesisValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IntegerValidator extends GenesisValidator {

    public void rejectEmpty(BaseRequestResult result, String fieldName, Integer fieldValue) {
        if (Optional.ofNullable(fieldValue).isEmpty() || fieldValue.equals(GenesisConstants.EMPTY_INT)) {
            putError(fieldName, String.format(GenesisConstants.VALIDATION_EMPTY_FIELD, fieldName), result);
        }
    }
}
