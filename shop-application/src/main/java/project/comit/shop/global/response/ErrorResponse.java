package project.comit.shop.global.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

    private int status;
    private String code;
    private String message;
}
