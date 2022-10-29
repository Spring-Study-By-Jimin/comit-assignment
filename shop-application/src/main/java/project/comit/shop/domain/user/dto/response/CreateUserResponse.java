package project.comit.shop.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserResponse {
    private String email;
}
