package com.devarchi33.persistance.jpa;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Configuration
public class JpaConfig {

    @Autowired
    private DataSourceProperties properties;
    private DataSource dataSouce;

    @Bean
    public DataSource realDataSource() {
        DataSourceBuilder factory = DataSourceBuilder.create(this.properties.getClassLoader())
                .url(this.properties.getUrl())
                .username(this.properties.getUsername())
                .password(this.properties.getPassword());
        this.dataSouce = factory.build();
        return this.dataSouce;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSouce);
    }

}
