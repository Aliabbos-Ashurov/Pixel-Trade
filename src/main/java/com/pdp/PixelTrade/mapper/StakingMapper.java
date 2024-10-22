package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.StakingCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.StakingUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.StakingResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Staking;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:50
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StakingMapper
        extends GenericMapper<Staking, StakingResponseDTO, StakingCreateDTO, StakingUpdateDTO> {
}
