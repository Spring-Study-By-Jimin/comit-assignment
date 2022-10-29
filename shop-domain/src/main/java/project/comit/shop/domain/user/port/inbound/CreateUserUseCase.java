package project.comit.shop.domain.user.port.inbound;

import project.comit.shop.domain.user.model.User;

public interface CreateUserUseCase {
    void createUser(User user);
}
