package com.pdp.PixelTrade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

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

    @Column(name = "app_name", nullable = false)
    private String appName;

    @Column(name = "app_url", nullable = false)
    private String appUrl;

    @ManyToOne
    private Collection collection;
}
