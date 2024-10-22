package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.P2PMarketCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2PMarketResponseDTO;
import com.pdp.PixelTrade.entity.wallet.P2PMarket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:42
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface P2PMarketMapper
        extends GenericMapper<P2PMarket, P2PMarketResponseDTO, P2PMarketCreateDTO, P2PMarketUpdateDTO> {

    @Override
    @Mappings({
            @Mapping(target = "seller.profilePictureUrl.url", source = "seller.profilePictureUrl")
    })
    P2PMarket toEntity(P2PMarketResponseDTO dto);

    @Override
    @Mappings({
            @Mapping(target = "seller.profilePictureUrl", source = "seller.profilePictureUrl.url")
    })
    P2PMarketResponseDTO toDTO(P2PMarket p2pMarket);
}
