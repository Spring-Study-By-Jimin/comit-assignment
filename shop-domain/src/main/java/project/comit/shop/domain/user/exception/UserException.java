package project.comit.shop.domain.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.comit.shop.domain.user.error.UserErrorCode;

@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException{

    private final UserErrorCode userErrorCode;

    public static UserException of(UserErrorCode userErrorCode) {
        return new UserException(userErrorCode);
    }
}
