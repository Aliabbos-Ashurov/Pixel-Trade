package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.StakingEventCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.StakingEventUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.StakingEventResponseDTO;
import com.pdp.PixelTrade.entity.wallet.StakingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:41
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StakingEventMapper
        extends GenericMapper<StakingEvent, StakingEventResponseDTO, StakingEventCreateDTO, StakingEventUpdateDTO> {
}
