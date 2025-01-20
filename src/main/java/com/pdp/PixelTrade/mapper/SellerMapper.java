package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.SellerCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.SellerUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.SellerResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Seller;
import org.mapstruct.*;
import org.mapstruct.Mapper;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:25
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface SellerMapper
        extends GenericMapper<Seller, SellerResponseDTO, SellerCreateDTO, SellerUpdateDTO> {

    @Override
    @Mappings({
            @Mapping(target = "profilePictureUrl", source = "profilePictureUrl.url")
    })
    SellerResponseDTO toDTO(Seller seller);

    @Override
    @Mappings({
            @Mapping(target = "profilePictureUrl.url", source = "profilePictureUrl")
    })
    Seller toEntity(SellerResponseDTO dto);

    @Override
    @Mapping(target = "profilePictureUrl", source = "profilePicture")
    Seller fromCreate(SellerCreateDTO dto);

}
