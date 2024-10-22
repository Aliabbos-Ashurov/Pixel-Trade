package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.P2POrderCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2POrderUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2POrderResponseDTO;
import com.pdp.PixelTrade.entity.wallet.P2POrder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:30
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface P2POrderMapper
        extends GenericMapper<P2POrder, P2POrderResponseDTO, P2POrderCreateDTO, P2POrderUpdateDTO> {
}
