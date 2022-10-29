package project.comit.shop.domain.file.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum FileErrorCode {

    EXTENSION_WRONG(HttpStatus.BAD_REQUEST, "잘못된 확장자");

    private final HttpStatus httpStatus;
    private final String message;
}
