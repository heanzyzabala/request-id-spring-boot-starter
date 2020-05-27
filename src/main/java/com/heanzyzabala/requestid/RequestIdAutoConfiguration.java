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
    public RequestId r() {
        return new ThreadLocalRequestId();
    }

    @Bean
    public RequestIdFilter requestIdFilter(RequestId requestId) {
        return new RequestIdFilter(requestId, properties, new AntPathMatcher());
    }
}
