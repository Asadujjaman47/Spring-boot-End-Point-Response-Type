package com.asad.DTO;

import java.time.LocalDateTime;

// POJO class = Plain Old Java Object
public class POJOResponse {
    private LocalDateTime timestamp;
    private int statusCode;
    private Object data;

    public POJOResponse(LocalDateTime timestamp, int statusCode, Object data) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getData() {
        return data;
    }
}
