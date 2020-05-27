package com.heanzyzabala.requestid;

import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestIdHandlerInterceptor implements HandlerInterceptor {

    private final RequestId requestId;
    private final RequestIdFilterProperties properties;
    private final PathMatcher matcher;

    public RequestIdHandlerInterceptor(RequestId requestId,
                                       RequestIdFilterProperties properties,
                                       PathMatcher matcher) {
        this.requestId = requestId;
        this.properties = properties;
        this.matcher = matcher;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
}
