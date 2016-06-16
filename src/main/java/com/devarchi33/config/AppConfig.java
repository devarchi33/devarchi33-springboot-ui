package com.devarchi33.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Configuration
public class AppConfig {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public CharacterEncodingFilter devarchi33CharacterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
