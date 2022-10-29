package project.comit.shop.domain.auth.port.outbound;

import project.comit.shop.domain.user.model.User;

public interface FindUserPort {

    User findUser(String email);
}
