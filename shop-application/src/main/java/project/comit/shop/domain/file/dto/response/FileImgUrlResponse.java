package project.comit.shop.domain.file.dto.response;

import lombok.Builder;
import lombok.Getter;
import project.comit.shop.domain.file.domain.File;

@Getter
public class FileImgUrlResponse {

    private String imgUrl;

    @Builder
    public FileImgUrlResponse(File file) {
        this.imgUrl = file.getImgUrl();
    }
}
