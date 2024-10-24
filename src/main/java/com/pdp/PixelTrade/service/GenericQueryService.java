package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.marker.DTO;
import com.pdp.PixelTrade.entity.BaseDomain;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 24/October/2024  14:53
 **/
public interface GenericQueryService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends DTO
        > {

    Response<R> find(@NotNull ID id);

    Response<List<R>> findAll();

    default <T> T find(@NotNull ID id, @NotNull Class<T> clazz) {
        return null;
    }
}
