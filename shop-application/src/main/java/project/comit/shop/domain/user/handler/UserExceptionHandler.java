package project.comit.shop.domain.user.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.comit.shop.domain.user.exception.UserException;
import project.comit.shop.global.response.ErrorResponse;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    protected ResponseEntity handleUserException(UserException e) {
        return ResponseEntity
                .status(e.getUserErrorCode().getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(e.getUserErrorCode().getHttpStatus().value())
                        .code(e.getUserErrorCode().toString())
                        .message(e.getUserErrorCode().getMessage())
                        .build());
    }
}
