package com.heanzyzabala.requestid;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(value = "request-id")
public class RequestIdFilterProperties {

    private String headerName = "X-Request-ID";
    private List<String> requiredPaths = new ArrayList<>();

    public RequestIdFilterProperties() {
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public void setRequiredPaths(List<String> requiredPaths) {
        this.requiredPaths = requiredPaths;
    }

    public String getHeaderName() {
        return headerName;
    }

    public List<String> getRequiredPaths() {
        return requiredPaths;
    }
}
