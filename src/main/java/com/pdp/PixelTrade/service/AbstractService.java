package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.mapper.Mapper;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:50
 **/
public abstract class AbstractService<R, M extends Mapper> {

    protected final R repository;
    protected final M mapper;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
