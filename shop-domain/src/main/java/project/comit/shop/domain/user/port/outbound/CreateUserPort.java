package project.comit.shop.domain.user.port.outbound;

import project.comit.shop.domain.user.model.User;

public interface CreateUserPort {
    void createUser(User user);
}
