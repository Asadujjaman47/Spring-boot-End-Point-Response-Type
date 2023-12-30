package com.asad.DTO;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class MyResponse2 {
    private LocalDateTime timestamp = LocalDateTime.now();
    private int statusCode;
    private Object data;

    public MyResponse2(int statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}

/*
OBJECT PATTERN FOLLOW:
ResponseTest response = new ResponseTest(
        responseCode,
        data
        )
 */
