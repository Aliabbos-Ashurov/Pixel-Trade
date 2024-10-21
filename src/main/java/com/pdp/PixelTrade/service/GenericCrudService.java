package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.marker.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  18:50
 **/
public interface GenericCrudService<
        ID extends Serializable,
        R extends DTO,
        CD extends DTO,
        UD extends DTO
        > extends GenericService {
    Response<R> create(CD dto);

    Response<R> update(UD dto);

    Response<R> delete(ID id);

    Response<List<R>> getAll();

    Response<R> getById(ID id);
}
