package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.FeeCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.FeeUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.FeeResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Fee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:20
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeeMapper
        extends GenericMapper<Fee, FeeResponseDTO, FeeCreateDTO, FeeUpdateDTO> {
}
