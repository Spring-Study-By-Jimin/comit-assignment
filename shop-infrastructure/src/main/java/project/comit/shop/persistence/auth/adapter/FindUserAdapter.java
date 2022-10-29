package project.comit.shop.persistence.auth.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.comit.shop.domain.auth.error.AuthErrorCode;
import project.comit.shop.domain.auth.exception.AuthException;
import project.comit.shop.domain.auth.port.outbound.FindUserPort;
import project.comit.shop.domain.user.model.User;
import project.comit.shop.persistence.user.entity.UserJpaEntity;
import project.comit.shop.persistence.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class FindUserAdapter implements FindUserPort {

    private final UserRepository userRepository;

    @Override
    public User findUser(String email) {

        UserJpaEntity userJpaEntity = userRepository.findByEmail(email).orElseGet(() -> {
            throw AuthException.of(AuthErrorCode.USER_NOT_FOUND);
        });
        return userJpaEntity.toDomain();
    }
}
