package project.comit.shop.persistence.user.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.comit.shop.domain.user.port.outbound.ExistsUserPort;
import project.comit.shop.persistence.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class ExistsUserAdapter implements ExistsUserPort {

    private final UserRepository userRepository;

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
