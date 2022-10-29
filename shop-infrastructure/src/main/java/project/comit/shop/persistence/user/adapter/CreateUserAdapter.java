package project.comit.shop.persistence.user.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.comit.shop.domain.user.model.User;
import project.comit.shop.domain.user.port.outbound.CreateUserPort;
import project.comit.shop.persistence.user.entity.UserJpaEntity;
import project.comit.shop.persistence.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserPort {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(UserJpaEntity.builder().user(user).build());
    }
}
