package com.heanzyzabala.requestid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(value = "request-id")
public class RequestIdFilterProperties {

    private String headerName = "X-Request-ID";
    private List<String> requiredPaths = new ArrayList<>();
}
