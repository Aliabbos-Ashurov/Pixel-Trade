package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  18:02
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletHistoryMapper {

    WalletHistoryDTO toDTO(WalletHistory walletHistory);

    WalletHistory toEntity(WalletHistoryDTO walletHistoryDTO);
}
