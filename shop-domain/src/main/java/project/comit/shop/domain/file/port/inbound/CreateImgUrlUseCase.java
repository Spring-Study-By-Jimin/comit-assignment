package project.comit.shop.domain.file.port.inbound;

import org.springframework.web.multipart.MultipartFile;
import project.comit.shop.domain.file.domain.File;

import java.io.IOException;

public interface CreateImgUrlUseCase {

    File createImgUrl(MultipartFile file) throws IOException;
}
