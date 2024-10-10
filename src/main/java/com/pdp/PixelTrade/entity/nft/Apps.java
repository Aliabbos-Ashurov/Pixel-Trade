package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Doniyor Nishonov
 * @since 09/October/2024  20:27
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "apps")
public class Apps extends BaseEntity {
    @NotBlank
    @Column(name = "app_name", nullable = false, unique = true)
    private String appName;

    @JoinColumn(nullable = false, unique = true)
    @OneToOne
    private Upload upload;
}
