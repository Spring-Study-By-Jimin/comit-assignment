package project.comit.shop.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.comit.shop.domain.user.dto.request.CreateUserRequest;
import project.comit.shop.domain.user.port.inbound.CreateUserUseCase;
import project.comit.shop.domain.user.dto.response.CreateUserResponse;
import project.comit.shop.global.response.DataResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<DataResponse<CreateUserResponse>> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        createUserUseCase.createUser(createUserRequest.toDomain());
        return DataResponse.ok("유저 생성 성공", CreateUserResponse.builder().email(createUserRequest.getEmail()).build());
    }
}
