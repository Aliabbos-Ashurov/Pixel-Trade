package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.dto.auth.TwoFactorAuthenticationCreateDTO;
import com.pdp.PixelTrade.dto.auth.TwoFactorAuthenticationResponseDTO;
import com.pdp.PixelTrade.dto.auth.TwoFactorAuthenticationUpdateDTO;
import com.pdp.PixelTrade.entity.TwoFactorAuthentication;
import com.pdp.PixelTrade.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  13:12
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TwoFactorAuthenticationMapper
        extends GenericMapper<TwoFactorAuthentication, TwoFactorAuthenticationResponseDTO, TwoFactorAuthenticationCreateDTO, TwoFactorAuthenticationUpdateDTO> {
}
