package project.comit.shop.domain.user.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode{

    USER_FORBIDDEN(HttpStatus.CONFLICT, "이미 존재하는 유저");

    private final HttpStatus httpStatus;
    private final String message;
}
