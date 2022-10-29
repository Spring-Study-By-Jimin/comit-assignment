package project.comit.shop.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.comit.shop.domain.auth.domain.AccessToken;
import project.comit.shop.domain.auth.domain.RefreshToken;
import project.comit.shop.domain.auth.dto.request.AuthTokenRequest;
import project.comit.shop.domain.auth.dto.response.AuthTokenResponse;
import project.comit.shop.domain.auth.port.inbound.CreateAccessTokenUseCase;
import project.comit.shop.domain.auth.port.inbound.CreateRefreshTokenUseCase;
import project.comit.shop.domain.auth.port.inbound.FindUserUseCase;
import project.comit.shop.domain.user.dto.response.CreateUserResponse;
import project.comit.shop.domain.user.model.User;
import project.comit.shop.global.response.DataResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final FindUserUseCase findUserUseCase;
    private final CreateAccessTokenUseCase createAccessTokenUseCase;
    private final CreateRefreshTokenUseCase createRefreshTokenUseCase;

    @PostMapping("/getAuthToken")
    public ResponseEntity<DataResponse<AuthTokenResponse>> getAuthToken(@Valid @RequestBody AuthTokenRequest authTokenRequest) {

        User user = findUserUseCase.findUser(authTokenRequest.getEmail(), authTokenRequest.getPw());
        AccessToken accessToken = createAccessTokenUseCase.createAccessToken(user.getEmail());
        RefreshToken refreshToken = createRefreshTokenUseCase.createRefreshToken(user.getEmail());

        return DataResponse.ok("토큰 생성 성공",
                AuthTokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build());
    }
}
