package com.pdp.PixelTrade.config;

import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 07/November/2024  10:09
 **/
public class DataSourceFactory {

    private static final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

    public static DataSourceBuilder<?> url(DataSourceConfigurator configurator) {
        return configurator.configure(dataSourceBuilder);
    }

    public static DataSourceBuilder<?> username(DataSourceConfigurator configurator) {
        return configurator.configure(dataSourceBuilder);
    }

    public static DataSourceBuilder<?> password(DataSourceConfigurator configurator) {
        return configurator.configure(dataSourceBuilder);
    }

    public static DataSourceBuilder<?> driver(DataSourceConfigurator configurator) {
        return configurator.configure(dataSourceBuilder);
    }
}
