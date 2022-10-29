package project.comit.shop.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.comit.shop.domain.user.error.UserErrorCode;
import project.comit.shop.domain.user.exception.UserException;
import project.comit.shop.domain.user.model.User;
import project.comit.shop.domain.user.port.inbound.CreateUserUseCase;
import project.comit.shop.domain.user.port.outbound.CreateUserPort;
import project.comit.shop.domain.user.port.outbound.ExistsUserPort;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;
    private final ExistsUserPort existsUserPort;

    public void createUser(User user) {

        if(existsUserPort.existByEmail(user.getEmail()))
            throw UserException.of(UserErrorCode.USER_FORBIDDEN);

        createUserPort.createUser(user);
    }
}
