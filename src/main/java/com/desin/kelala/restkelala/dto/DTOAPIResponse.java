package com.desin.kelala.restkelala.dto;

import java.util.Date;

public class DTOAPIResponse<T> {
    private final T response;
    private final Long timestamp;


    public DTOAPIResponse(T response) {
        this.response = response;
        this.timestamp = new Date().getTime();
    }
}
