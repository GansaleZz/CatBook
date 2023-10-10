package genesis.api;

import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
public class BaseRequestResult {

    private static final String COMMON_ERRORS = "common";

    private Map<String, List<String>> errors = new LinkedHashMap<>();

    public void putError(String error) {
        putError(COMMON_ERRORS, error);
    }

    public void putError(String fieldName, String error) {
        List<String> errorValues = errors.get(fieldName);
        if (CollectionUtils.isEmpty(errorValues)) {
            errorValues = new LinkedList<>();
        }

        errorValues.add(error);
        errors.put(fieldName, errorValues);
    }
}
