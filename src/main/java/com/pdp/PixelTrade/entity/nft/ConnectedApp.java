package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:02
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "connected_app")
public class ConnectedApp extends BaseEntity {

    @NotBlank
    @Column(name = "app_name", nullable = false)
    private String appName;

    @NotBlank
    @Column(name = "app_url", nullable = false)
    private String appUrl;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;
}
