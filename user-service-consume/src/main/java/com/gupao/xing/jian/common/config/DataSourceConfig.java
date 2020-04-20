package com.gupao.xing.jian.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "db1DataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSourceProperties db1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "db1DataSource")
    public DataSource db1DataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "db2DataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSourceProperties db2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "db2DataSource")
    public DataSource db2DataSource(@Qualifier("db2DataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
