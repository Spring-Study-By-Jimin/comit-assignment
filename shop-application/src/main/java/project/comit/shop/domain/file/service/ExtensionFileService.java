package project.comit.shop.domain.file.service;

import org.springframework.stereotype.Service;
import project.comit.shop.domain.file.error.FileErrorCode;
import project.comit.shop.domain.file.exception.FileException;
import project.comit.shop.domain.file.port.inbound.ExtensionFileUseCase;

@Service
public class ExtensionFileService implements ExtensionFileUseCase {

    @Override
    public void extensionFile(String fileName) {

        final String[] permitExtension = {".jpg", ".jpeg", ".png"};
        boolean check = false;

        for (String permit : permitExtension) {
            if(fileName.contains(permit)) {
                check = true;
                break;
            }
        }
        if (check == false) throw FileException.of(FileErrorCode.EXTENSION_WRONG);
    }
}
