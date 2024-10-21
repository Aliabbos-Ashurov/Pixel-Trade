package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.marker.DTO;
import com.pdp.PixelTrade.entity.BaseDomain;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:01
 **/
public interface GenericMapper<
        E extends BaseDomain,
        D extends DTO,
        CD extends DTO,
        UD extends DTO> extends Mapper {

    E toEntity(D dto);

    D toDTO(E entity);

    E fromCreate(CD dto);

    E fromUpdate(UD dto);
}
