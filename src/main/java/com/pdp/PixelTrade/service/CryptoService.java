package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.CryptoCreateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoResponseDTO;
import com.pdp.PixelTrade.entity.Crypto;
import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.enums.AwsPackage;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.CryptoMapper;
import com.pdp.PixelTrade.repository.CryptoRepository;
import com.pdp.PixelTrade.service.aws.S3Service;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:22
 **/
@Service
public class CryptoService extends AbstractService<CryptoRepository, CryptoMapper> {

    private final S3Service s3Service;

    protected CryptoService(CryptoRepository repository, CryptoMapper mapper, S3Service s3Service) {
        super(repository, mapper);
        this.s3Service = s3Service;
    }

    @Async
    @Transactional
    public void save(@NotNull CryptoCreateDTO dto) {

        String imageURL = s3Service.uploadFile(dto.image(), AwsPackage.CRYPTO);
        Crypto crypto = mapper.fromCreate(dto);

        Upload upload = Upload.builder()
                .size(dto.image().getSize())
                .fileType(StringUtils.getFilenameExtension(dto.image().getOriginalFilename()))
                .originalName(dto.image().getName())
                .generatedName(imageURL.substring(imageURL.lastIndexOf("/") + 1))
                .url(imageURL)
                .build();

        crypto.setImage(upload);
        repository.save(crypto);
    }


    public Optional<BigDecimal> getFeePercentage(@NotNull CryptoType type) {
        return repository.getFeePercentage(type.getCode());
    }

    public Optional<Crypto> findByName(@NotNull String name) {
        return repository.findByName(name);
    }

    public Optional<Crypto> findBySymbol(@NotNull String symbol) {
        return repository.findBySymbol(symbol);
    }

    public Response<List<CryptoResponseDTO>> findAll() {
        return Response.ok(repository.findAll().stream()
                .map(mapper::toDTO)
                .toList());
    }

    public void updateFeePercentage(@NotNull Long id, @NotNull BigDecimal feePercentage) {
        repository.updateFeePercentage(id, feePercentage);
    }
}
