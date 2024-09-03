package com.pdp.PixelTrade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    @Column(name = "original_name", nullable = false)
    private String originalName;

    @NotBlank
    @Column(name = "generated_name", nullable = false, unique = true)
    private String generatedName;

    @PositiveOrZero
    @Column(name = "size", nullable = false)
    private Long size;

    @NotBlank
    @Column(name = "extension", nullable = false)
    private String extension;

    @NotBlank
    @Column(name = "file_type", nullable = false)
    private String fileType;

    @Column(name = "url", nullable = false)
    private String url;
}
