package com.asad.DTO;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class MyResponseBuilder2 {
    private final LocalDateTime timestamp;
    private final int statusCode;
    private final Map<String, Object> data;

    private MyResponseBuilder2(LocalDateTime timestamp, int statusCode, Map<String, Object> data) {
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
        private Map<String, Object> data;

        private ResponseBuilder() {
            this.timestamp = LocalDateTime.now();
        }

        public ResponseBuilder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder data(String key, Object value) {
            if (this.data == null) {
                this.data = new HashMap<>();
            }
            this.data.put(key, value);
            return this;
        }

        public MyResponseBuilder2 build() {
            return new MyResponseBuilder2(timestamp, statusCode, data);
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