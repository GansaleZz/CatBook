package catBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleApplicationException(Exception e) {
        e.printStackTrace();

        return new ResponseEntity<>("Oops. Something went wrong... Try later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationDTOException.class)
    @ResponseBody
    public ResponseEntity<Object> handleValidationDTOEException(ValidationDTOException e) {
        return new ResponseEntity<>(e.getResult(), HttpStatus.BAD_REQUEST);
    }
}
