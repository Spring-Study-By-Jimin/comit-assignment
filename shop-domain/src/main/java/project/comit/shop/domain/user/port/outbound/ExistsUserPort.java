package project.comit.shop.domain.user.port.outbound;

public interface ExistsUserPort {
    boolean existByEmail(String email);
}
