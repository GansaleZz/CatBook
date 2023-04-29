package genesis.exception;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ApiResponse(responseCode = "404")
public class APIExceptionNotFound extends RuntimeException {

    public APIExceptionNotFound(String message) {
        super(message);
    }
}
