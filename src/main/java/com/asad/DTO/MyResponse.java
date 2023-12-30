package com.asad.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class MyResponse {
    private LocalDateTime timestamp;
    private int statusCode;
    private Object data;
}

/*
OBJECT PATTERN FOLLOW:
ResponseTest response = new ResponseTest(
        timestamp
        responseCode,
        data
        )
 */