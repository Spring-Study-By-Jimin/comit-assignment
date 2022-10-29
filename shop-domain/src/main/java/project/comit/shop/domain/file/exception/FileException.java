package project.comit.shop.domain.file.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.comit.shop.domain.file.error.FileErrorCode;
import project.comit.shop.domain.user.exception.UserException;

@Getter
@RequiredArgsConstructor
public class FileException extends RuntimeException{

    private final FileErrorCode fileErrorCode;

    public static FileException of(FileErrorCode fileErrorCode) {
        return new FileException(fileErrorCode);
    }
}
