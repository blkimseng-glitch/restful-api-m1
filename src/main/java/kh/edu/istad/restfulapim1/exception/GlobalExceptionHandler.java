package kh.edu.istad.restfulapim1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorRespone<?>> handleResponseStatusException(ResponseStatusException e){
        ApiErrorRespone<?> body =  ApiErrorRespone.builder()
                .code(e.getStatusCode().toString())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}
