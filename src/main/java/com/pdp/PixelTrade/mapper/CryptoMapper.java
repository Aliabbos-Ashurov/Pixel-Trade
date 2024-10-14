package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.request.transaction.CryptoCreateDTO;
import com.pdp.PixelTrade.entity.Crypto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:33
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CryptoMapper {

    @Mapping(target = "imageURL", ignore = true)
    Crypto toCrypto(CryptoCreateDTO dto);
}
