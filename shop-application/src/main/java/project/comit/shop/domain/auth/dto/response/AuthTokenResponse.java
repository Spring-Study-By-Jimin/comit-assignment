package project.comit.shop.domain.auth.dto.response;

import lombok.Builder;
import lombok.Getter;
import project.comit.shop.domain.auth.domain.AccessToken;
import project.comit.shop.domain.auth.domain.RefreshToken;

@Getter
public class AuthTokenResponse {

    private String accessToken;
    private String refreshToken;

    @Builder
    public AuthTokenResponse(AccessToken accessToken, RefreshToken refreshToken) {
        this.accessToken = accessToken.getToken();
        this.refreshToken = refreshToken.getToken();
    }
}
