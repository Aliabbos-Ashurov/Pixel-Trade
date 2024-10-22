package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.CryptoAssetCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.CryptoAssetUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:30
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CryptoAssetMapper extends
        GenericMapper<CryptoAsset, CryptoAssetResponseDTO, CryptoAssetCreateDTO, CryptoAssetUpdateDTO> {

}
