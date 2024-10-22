package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.P2PMarketCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2PMarketResponseDTO;
import com.pdp.PixelTrade.entity.wallet.P2PMarket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:42
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface P2PMarketMapper extends
        GenericMapper<P2PMarket, P2PMarketResponseDTO, P2PMarketCreateDTO, P2PMarketUpdateDTO> {
}
