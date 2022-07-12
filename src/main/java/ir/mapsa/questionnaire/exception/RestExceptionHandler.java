package ir.mapsa.questionnaire.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> NotFoundExceptionHandler(NotFoundException notFoundException){
        ApiEr apiEr = new ApiEr(notFoundException.getMessage(), NOT_FOUND);
        return buildResponseEntity(apiEr);
    }
    private ResponseEntity<Object> buildResponseEntity(ApiEr apiEr){
        return new ResponseEntity<>(apiEr,apiEr.getStatus());
    }
}