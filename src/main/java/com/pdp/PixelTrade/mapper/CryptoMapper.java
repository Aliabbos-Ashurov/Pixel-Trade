package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.CryptoCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.CryptoUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoResponseDTO;
import com.pdp.PixelTrade.entity.Crypto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:33
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CryptoMapper
        extends GenericMapper<Crypto, CryptoResponseDTO, CryptoCreateDTO, CryptoUpdateDTO> {

    @Override
    @Mapping(target = "image", ignore = true)
    Crypto fromCreate(CryptoCreateDTO dto);

    @Override
    @Mapping(target = "imageURL", source = "image.url")
    CryptoResponseDTO toDTO(Crypto crypto);

}
