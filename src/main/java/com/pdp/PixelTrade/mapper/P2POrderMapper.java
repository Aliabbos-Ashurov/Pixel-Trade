package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.response.P2POrderDTO;
import com.pdp.PixelTrade.entity.wallet.P2POrder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:30
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface P2POrderMapper {

    P2POrderDTO toDTO(P2POrder p2POrder);

    P2POrder toEntity(P2POrderDTO p2POrderDTO);
}
