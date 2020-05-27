package com.heanzyzabala.requestid;

public interface RequestId {
    String get(String key);
    void set(String key, String value);
    void remove(String key);
}
