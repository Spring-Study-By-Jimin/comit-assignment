package project.comit.shop.domain.user.dto.request;

import lombok.Getter;
import project.comit.shop.domain.user.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class CreateUserRequest {

    @Email
    private String email;
    @NotBlank
    private String pw;
    @NotBlank
    private String name;

    public User toDomain() {
        return User.builder()
                .email(email)
                .pw(pw)
                .name(name).build();
    }
}
