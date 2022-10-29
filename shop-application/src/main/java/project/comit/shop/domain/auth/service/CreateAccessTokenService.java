package project.comit.shop.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.comit.shop.domain.auth.domain.AccessToken;
import project.comit.shop.domain.auth.port.inbound.CreateAccessTokenUseCase;

@Service
@RequiredArgsConstructor
public class CreateAccessTokenService implements CreateAccessTokenUseCase {

    private final GeneralTokenService generalTokenService;

    private static final Long ACCESS_TOKEN_EXPIRE_TIME = 1000L * 3600 * 24 * 3; // 3일

    @Override
    public AccessToken createAccessToken(String email) {
        String accessToken = generalTokenService.generalAccessToken(email, ACCESS_TOKEN_EXPIRE_TIME, "ACCESS_TOKEN");
        return AccessToken.builder().token(accessToken).build();
    }
}
