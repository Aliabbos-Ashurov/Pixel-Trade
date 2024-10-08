package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  13:55
 **/
@Entity
@Table(name = "uploads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Upload extends Auditable {

    @NotBlank
    @Size(max = 255)
    @Column(name = "original_name", nullable = false, length = 255)
    private String originalName;

    @NotBlank
    @Size(max = 255)
    @Column(name = "generated_name", nullable = false, unique = true, length = 255)
    private String generatedName;

    @PositiveOrZero(message = "File size must be zero or positive")
    @Column(name = "size", nullable = false)
    private Long size;

    @NotBlank
    @Size(max = 10)
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @NotBlank
    @Size(max = 50)
    @Column(name = "file_type", nullable = false, length = 50)
    private String fileType;

    @NotBlank
    @URL(message = "Invalid URL format")
    @Column(name = "url", nullable = false)
    private String url;
}

