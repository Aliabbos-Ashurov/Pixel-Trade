package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:02
 **/
@Entity
@Table(name = "connected_app")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ConnectedApp extends Auditable {

    @NotBlank
    @Size(max = 255)  // Limit the name length
    @Column(name = "app_name", nullable = false, length = 255)
    private String appName;

    @NotBlank
    @URL
    @Size(max = 255)
    @Column(name = "app_url", nullable = false, length = 255)
    private String appUrl;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;
}
