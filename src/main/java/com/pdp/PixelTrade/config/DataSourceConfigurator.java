package com.pdp.PixelTrade.config;

import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 07/November/2024  10:05
 **/
@FunctionalInterface
public interface DataSourceConfigurator {
    DataSourceBuilder<?> configure(DataSourceBuilder<?> dataSourceBuilder);
}
