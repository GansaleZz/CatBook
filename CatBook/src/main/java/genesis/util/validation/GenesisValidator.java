package genesis.util.validation;

import genesis.api.BaseRequestResult;

public class GenesisValidator {

    protected void putError(String fieldName, String error, BaseRequestResult result) {
        result.putError(fieldName, error);
    }
}
