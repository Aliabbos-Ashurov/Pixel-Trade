package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.WalletCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.WalletUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.dto.transaction.response.WalletResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:29
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletMapper
        extends GenericMapper<Wallet, WalletResponseDTO, WalletCreateDTO, WalletUpdateDTO> {

    @Override
    @Mappings({
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "updatedBy", ignore = true),
            @Mapping(target = "deleted", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "maxWithdrawalLimit", ignore = true),
            @Mapping(target = "minWithdrawalLimit", ignore = true)
    })
    Wallet toEntity(WalletResponseDTO dto);

    @Mappings({
            @Mapping(target = "cryptoAssets", source = "cryptoAssets")
    })
    WalletResponseDTO toDTO(Wallet wallet, List<CryptoAssetResponseDTO> cryptoAssets);
}
