package catBook.exception;

import genesis.api.BaseRequestResult;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class ValidationDTOException extends RuntimeException {

    private final BaseRequestResult result;

    public ValidationDTOException(BaseRequestResult result) {
        super();

        this.result = result;
    }
}
