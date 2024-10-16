package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.response.WalletDTO;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:29
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletMapper {

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
    Wallet toWallet(WalletDTO walletDTO);

    WalletDTO toWalletDTO(Wallet wallet);
}
