package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.CryptoAssetCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.CryptoAssetUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:30
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CryptoAssetMapper
        extends GenericMapper<CryptoAsset, CryptoAssetResponseDTO, CryptoAssetCreateDTO, CryptoAssetUpdateDTO> {


    @Mappings({
            @Mapping(target = "balance", source = "balance"),
            @Mapping(target = "perPrice", source = "perPrice")
    })
    CryptoAssetResponseDTO toDTO(CryptoAsset cryptoAsset, BigDecimal balance, BigDecimal perPrice);

}
