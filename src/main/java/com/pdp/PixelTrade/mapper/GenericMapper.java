package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.marker.Request;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.entity.BaseDomain;

/**
 * @param <E>  Entity type that extends BaseDomain
 * @param <R>  Response (DTO) type
 * @param <CD> Create DTO type
 * @param <UD> Update DTO type
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:01
 * abstract Mapper
 */
public interface GenericMapper<
        E extends BaseDomain,
        R extends Response,
        CD extends Request,
        UD extends Request> extends Mapper {

    E toEntity(R dto);

    R toDTO(E entity);

    E fromCreate(CD dto);

    E fromUpdate(UD dto);
}
