package project.comit.shop.domain.auth.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshToken {

    private String token;
}
