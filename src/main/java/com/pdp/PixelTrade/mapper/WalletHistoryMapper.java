package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.WalletHistoryCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.WalletHistoryUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  18:02
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletHistoryMapper
        extends GenericMapper<WalletHistory, WalletHistoryResponseDTO, WalletHistoryCreateDTO, WalletHistoryUpdateDTO> {


    @Override
    @Mappings({
            @Mapping(target = "cryptoType", source = "walletHistory.transaction.cryptoType"),
            @Mapping(target = "confirmedAt", source = "walletHistory.transaction.confirmedAt"),
            @Mapping(target = "description", source = "walletHistory.description")
    })
    WalletHistoryResponseDTO toDTO(WalletHistory walletHistory);

}
