package com.asad.DTO;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class MyResponseBuilder {
    private final LocalDateTime timestamp;
    private final int statusCode;
    private final Object data;

    private MyResponseBuilder(LocalDateTime timestamp, int statusCode, Object data) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public static class ResponseBuilder {
        private LocalDateTime timestamp;
        private int statusCode;
        private Object data;

        private ResponseBuilder() {
            this.timestamp = LocalDateTime.now();
        }

        public ResponseBuilder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public MyResponseBuilder build() {
            return new MyResponseBuilder(timestamp, statusCode, data);
        }
    }
}

/*
OBJECT PATTERN FOLLOW:
MyResponseBuilder response = MyResponseBuilder.builder()
        .statusCode(200)
        .userData(userData)
        .build();
 */