package project.comit.shop.domain.auth.port.inbound;

import project.comit.shop.domain.auth.domain.RefreshToken;

public interface CreateRefreshTokenUseCase {

    RefreshToken createRefreshToken(String email);
}
