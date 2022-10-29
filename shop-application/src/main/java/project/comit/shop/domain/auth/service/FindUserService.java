package project.comit.shop.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.comit.shop.domain.auth.error.AuthErrorCode;
import project.comit.shop.domain.auth.exception.AuthException;
import project.comit.shop.domain.auth.port.inbound.FindUserUseCase;
import project.comit.shop.domain.auth.port.outbound.FindUserPort;
import project.comit.shop.domain.user.model.User;

@Service
@RequiredArgsConstructor
public class FindUserService implements FindUserUseCase {

    private final FindUserPort findUserPort;

    @Override
    public User findUser(String email, String pw) {

        User user = findUserPort.findUser(email);

        CheckUserPw(user, pw);
        return user;
    }

    protected void CheckUserPw(User user, String pw) {
        if(!user.getPw().equals(pw)) throw AuthException.of(AuthErrorCode.USER_PW_WRONG);
    }
}
