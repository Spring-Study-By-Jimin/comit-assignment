package project.comit.shop.domain.auth.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.comit.shop.domain.auth.exception.AuthException;
import project.comit.shop.global.response.ErrorResponse;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity handleAuthException(AuthException e) {
        return ResponseEntity
                .status(e.getAuthErrorCode().getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(e.getAuthErrorCode().getHttpStatus().value())
                        .code(e.getAuthErrorCode().toString())
                        .message(e.getAuthErrorCode().getMessage())
                        .build());
    }
}
