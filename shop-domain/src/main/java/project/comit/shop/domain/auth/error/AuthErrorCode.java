package project.comit.shop.domain.auth.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 유저"),
    USER_PW_WRONG(HttpStatus.UNAUTHORIZED, "일치하지 않는 비밀번호");

    private final HttpStatus httpStatus;
    private final String message;
}
