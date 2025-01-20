package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.marker.DTO;
import com.pdp.PixelTrade.entity.BaseDomain;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:03
 **/
public interface GenericCrudService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends DTO,
        CD extends DTO,
        UD extends DTO
        > extends GenericService, GenericQueryService<ID, E, R> {

    Response<R> create(@NotNull CD dto);

    Response<Boolean> update(@NotNull UD dto);

    Response<Boolean> delete(@NotNull ID id);
}
