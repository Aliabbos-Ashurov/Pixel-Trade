package com.pdp.PixelTrade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class Metadata extends Auditable {

    @Column(columnDefinition = "TEXT")
    private String attributes;  // JSON string containing attributes like rarity, etc.
    //"attributes": [
    //    {
    //      "trait_type": "Fur Color",
    //      "value": "Purple"
    //    },
    //    {
    //      "trait_type": "Rarity",
    //      "value": "Legendary"
    //    }
    //  ],

    @Column(name = "external_url")
    private String externalUrl;

    @Column(name = "creator_royalty")
    private String creatorRoyalty;  // Royalty information for the creator

    @Column(name = "provenance")
    private String provenance;  // Provenance information
}
