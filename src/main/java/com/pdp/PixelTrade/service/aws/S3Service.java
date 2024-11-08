package com.pdp.PixelTrade.service.aws;

import com.pdp.PixelTrade.enums.AwsPackage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.Objects;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:08
 **/
@Service
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @SneakyThrows
    public String uploadFile(@NotNull MultipartFile file, AwsPackage path) {
        String uniqueFileName = generateFileName(file, path);
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(uniqueFileName)
                .contentType(file.getContentType())
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
        return getFileUrl(uniqueFileName, path);
    }

    public ResponseBytes<GetObjectResponse> downloadFile(@NotBlank @NotNull String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        return s3Client.getObjectAsBytes(getObjectRequest);
    }

    public void deleteFile(@NotBlank @NotNull String key) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
    }

    private String generateFileName(@NotNull MultipartFile file, AwsPackage directory) {
        return directory.getDirectory() + "/" +
                java.util.UUID.randomUUID().toString().substring(0, 5) + "-" +
                Objects.requireNonNull(file.getOriginalFilename()).replace(" ", "_");
    }

    /*return String.format("https://%s.s3.%s.amazonaws.com/public/%s",
               bucketName,
               Region.US_EAST_1.id(),
               key);*/
    private String getFileUrl(String key, AwsPackage directory) {
        return String.format("https://%s.s3.amazonaws.com/%s",
                bucketName,
                key);
    }
}
