package project.comit.shop.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.comit.shop.domain.auth.domain.RefreshToken;
import project.comit.shop.domain.auth.port.inbound.CreateRefreshTokenUseCase;

@Service
@RequiredArgsConstructor
public class CreateRefreshTokenService implements CreateRefreshTokenUseCase {

    private final GeneralTokenService generalTokenService;

    private static final Long REFRESH_TOKEN_EXPIRE_TIME = 1000L * 3600 * 24 * 7; // 7일

    @Override
    public RefreshToken createRefreshToken(String email) {
        String refreshToken = generalTokenService.generalAccessToken(email, REFRESH_TOKEN_EXPIRE_TIME, "REFRESH_TOKEN");
        return RefreshToken.builder().token(refreshToken).build();
    }
}
