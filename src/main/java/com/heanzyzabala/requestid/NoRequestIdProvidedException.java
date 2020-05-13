package com.heanzyzabala.requestid;

public class NoRequestIdProvidedException extends RuntimeException {

    public NoRequestIdProvidedException(String uri, String headerName) {
        super("No request id: " + headerName + " found in path: " + uri);
    }
}
