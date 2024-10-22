package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.MiningEventCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.MiningEventUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.MiningEventResponseDTO;
import com.pdp.PixelTrade.entity.wallet.MiningEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:24
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MiningEventMapper
        extends GenericMapper<MiningEvent, MiningEventResponseDTO, MiningEventCreateDTO, MiningEventUpdateDTO> {
}
