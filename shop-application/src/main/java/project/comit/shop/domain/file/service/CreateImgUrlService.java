package project.comit.shop.domain.file.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.comit.shop.domain.file.domain.File;
import project.comit.shop.domain.file.port.inbound.CreateImgUrlUseCase;
import project.comit.shop.domain.file.port.inbound.ExtensionFileUseCase;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateImgUrlService implements CreateImgUrlUseCase {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client s3Client;
    private final ExtensionFileUseCase extensionFileUseCase;

    @Override
    public File createImgUrl(MultipartFile file) throws IOException {

        extensionFileUseCase.extensionFile(file.getOriginalFilename());

        String ext = file.getOriginalFilename().split("\\.")[1];

        String s3FileName = UUID.randomUUID() + "." + ext;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        s3Client.putObject(bucket, s3FileName, file.getInputStream(), metadata);
        return File.builder().imgUrl(s3Client.getUrl(bucket, s3FileName).toString()).build();
    }
}
