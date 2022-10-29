package project.comit.shop.domain.file.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import project.comit.shop.domain.file.domain.File;
import project.comit.shop.domain.file.dto.response.FileImgUrlResponse;
import project.comit.shop.domain.file.port.inbound.CreateImgUrlUseCase;
import project.comit.shop.global.response.DataResponse;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final CreateImgUrlUseCase createImgUrlUseCase;

    @PostMapping("/getUrl")
    public ResponseEntity<DataResponse<FileImgUrlResponse>> createImgUrl(MultipartFile multipartFile) throws IOException {
        File file = createImgUrlUseCase.createImgUrl(multipartFile);
        return DataResponse.ok("Url 생성 성공", FileImgUrlResponse.builder().file(file).build());
    }
}
