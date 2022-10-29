package project.comit.shop.domain.auth.port.inbound;

import project.comit.shop.domain.auth.domain.AccessToken;

public interface CreateAccessTokenUseCase {

    AccessToken createAccessToken(String email);
}
