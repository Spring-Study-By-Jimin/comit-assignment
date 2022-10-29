package project.comit.shop.domain.auth.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.comit.shop.domain.auth.error.AuthErrorCode;
import project.comit.shop.domain.user.exception.UserException;

@Getter
@RequiredArgsConstructor
public class AuthException extends RuntimeException{

    private final AuthErrorCode authErrorCode;

    public static AuthException of(AuthErrorCode authErrorCode) {
        return new AuthException(authErrorCode);
    }
}
