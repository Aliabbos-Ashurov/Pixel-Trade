package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:30
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CryptoAssetMapper {

    @Mappings({
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "updatedBy", ignore = true),
            @Mapping(target = "deleted", ignore = true),
            @Mapping(target = "wallet", ignore = true),
    })
    CryptoAsset toCryptoAsset(CryptoAssetDTO cryptoAssetDTO);

    CryptoAssetDTO toCryptoAssetDTO(CryptoAsset cryptoAsset);
}
