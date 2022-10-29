package project.comit.shop.global.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.comit.shop.global.error.GlobalErrorCode;
import project.comit.shop.global.response.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(500)
                .body(ErrorResponse.builder()
                        .status(GlobalErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus().value())
                        .code(GlobalErrorCode.INTERNAL_SERVER_ERROR.name())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handleValidException(MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> errors.put(((FieldError) error).getField(), error.getDefaultMessage()));

        return ResponseEntity.status(400).body(errors);
    }
}
