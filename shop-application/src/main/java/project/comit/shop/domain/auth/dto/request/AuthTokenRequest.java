package project.comit.shop.domain.auth.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class AuthTokenRequest {

    @Email
    private String email;
    @NotBlank
    private String pw;
}
