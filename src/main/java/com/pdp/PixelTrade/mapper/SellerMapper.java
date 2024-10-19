package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.response.SellerResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:25
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SellerMapper {

    @Mappings({
            @Mapping(target = "profilePictureUrl", source = "profilePictureUrl.url")
    })
    SellerResponseDTO toSellerResponseDTO(Seller seller);

}
