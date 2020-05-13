package com.heanzyzabala.requestid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableConfigurationProperties({ RequestIdFilterProperties.class })
public class RequestIdAutoConfiguration {

    @Autowired
    private RequestIdFilterProperties properties;

    @Bean
    public RequestIdFilter filter() {
        return new RequestIdFilter(properties, new AntPathMatcher());
    }
}
