package project.comit.shop.domain.auth.port.inbound;

import project.comit.shop.domain.user.model.User;

public interface FindUserUseCase {

    User findUser(String email, String pw);
}
