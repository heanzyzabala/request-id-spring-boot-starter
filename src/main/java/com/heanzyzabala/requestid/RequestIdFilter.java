package com.heanzyzabala.requestid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RequestIdFilter extends OncePerRequestFilter {

    private RequestIdFilterProperties properties;
    private PathMatcher matcher;

    public RequestIdFilter(RequestIdFilterProperties properties, PathMatcher matcher) {
        this.properties = properties;
        this.matcher = matcher;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestIdHeader = request.getHeader(properties.getHeaderName());
        String uri = request.getRequestURI();
        if(isRequired(uri) && requestIdHeader == null) {
            log.error("Missing request ID: {} in path: {}", properties.getHeaderName(), uri);
            throw new MissingRequestIdException(properties.getHeaderName(), uri);
        }
    }

    private boolean isRequired(String uri) {
        return properties.getRequiredPaths().stream()
                .anyMatch(u -> matcher.match(uri, u));
    }
}
