package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.CloudMiningCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.CloudMiningUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CloudMiningResponseDTO;
import com.pdp.PixelTrade.entity.wallet.CloudMining;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:04
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CloudMiningMapper
        extends GenericMapper<CloudMining, CloudMiningResponseDTO, CloudMiningCreateDTO, CloudMiningUpdateDTO> {
}
