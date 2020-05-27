package com.heanzyzabala.requestid;

import java.util.Map;

public class ThreadLocalRequestId implements RequestId {

    private final ThreadLocal<Map<String, String>> context = new ThreadLocal<>();

    @Override
    public String get(String key) {
        return context.get().get(key);
    }

    @Override
    public void set(String key, String value) {
        context.get().put(key, value);
    }

    @Override
    public void remove(String key) {
        context.get().remove(key);
    }
}
