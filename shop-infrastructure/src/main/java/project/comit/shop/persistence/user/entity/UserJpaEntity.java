package project.comit.shop.persistence.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.comit.shop.domain.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {

    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String pw;

    @Builder
    public UserJpaEntity(User user) {

        this.email = user.getEmail();
        this.name = user.getName();
        this.pw = user.getPw();
    }

    public User toDomain() {
        return User.builder()
                .email(email)
                .pw(pw)
                .name(name).build();
    }
}
