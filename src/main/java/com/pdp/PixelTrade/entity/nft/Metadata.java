package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:59
 **/
@Entity
@Table(name = "metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Metadata extends BaseEntity {

    @OneToOne(mappedBy = "metadata")
    private NFT nft;

    @NotBlank
    @Column(columnDefinition = "JSON", nullable = false)
    private String attributes;
}

