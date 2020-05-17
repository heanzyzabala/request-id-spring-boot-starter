package com.heanzyzabala.requestid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

@Slf4j
@Configuration
@EnableConfigurationProperties({ RequestIdFilterProperties.class })
public class RequestIdAutoConfiguration {

    @Autowired
    private RequestIdFilterProperties properties;

    @Bean
    public RequestIdFilter filter() {
        log.info("Configured request id: {} and required paths: {}", properties.getHeaderName(), properties.getRequiredPaths());
        return new RequestIdFilter(properties, new AntPathMatcher());
    }
}
