package com.heanzyzabala.requestid;

import lombok.Getter;

@Getter
public class MissingRequestIdException extends RuntimeException {

    private final String headerName;
    private final String uri;

    public MissingRequestIdException(String headerName, String uri) {
        super("Missing request ID: "+ headerName + " in path: " + uri);
        this.headerName = headerName;
        this.uri = uri;
    }
}
