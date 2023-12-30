package com.asad.controller;

import com.asad.DTO.*;
import com.asad.model.TestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class testController {

    //String Response
    @GetMapping("test")
    public String test() {
        return "test String Response";
    }

    // RAW Response Entity
    @GetMapping("test2")
    public ResponseEntity test2() {
        ResponseEntity responseEntity = new ResponseEntity("RAW Response Entity", HttpStatus.OK);
        return responseEntity;
    }

    // RAW Response Entity inline
    @GetMapping("test3")
    public ResponseEntity test3() {
        return new ResponseEntity("RAW Response Entity inline", HttpStatus.OK);
    }

    // Response Entity any type : ?
    @GetMapping("test4")
    public ResponseEntity<?> test4() {
        return new ResponseEntity<>("Response Entity any type : ?", HttpStatus.OK);
    }

    // Sent a specific type of ENTITY
    @GetMapping("test5")
    public ResponseEntity<TestModel> test5() {
        TestModel res = new TestModel(1, "Sent a specific type of ENTITY");
        return new ResponseEntity<TestModel>(res, HttpStatus.OK);
    }

    // Sent Custom pattern | MAP
    @GetMapping("test6")
    public ResponseEntity<Map<String, Object>> test6() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("responseCode", HttpStatus.OK.value());
        response.put("data", "Sent Custom pattern | MAP");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // SENT POJO class = Plain Old Java Object
    @GetMapping("test7")
    public ResponseEntity<POJOResponse> test7() {
        POJOResponse response = new POJOResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "SENT POJO class = Plain Old Java Object"
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // SENT DTO = Data Transfer objects
    @GetMapping("test8")
    public ResponseEntity<MyResponse> test8() {
        MyResponse response = new MyResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "SENT DTO = Data Transfer objects"
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // SENT DTO inline
    @GetMapping("test9")
    public ResponseEntity<MyResponse> test9() {

        return new ResponseEntity<>(new MyResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "SENT DTO inline"
        ), HttpStatus.OK);
    }

    // SET timestamp automatically
    @GetMapping("test10")
    public ResponseEntity<MyResponse2> test10() {

        return new ResponseEntity<>(new MyResponse2(
                HttpStatus.OK.value(),
                "SET timestamp automatically"
        ), HttpStatus.OK);
    }

    // USE builder() | Best Practice
    @GetMapping("test11")
    public ResponseEntity<MyResponseBuilder> test11() {
/*
        ResponseEntity<MyResponseBuilder> responseEntity = new ResponseEntity<>(MyResponseBuilder.builder()
                .statusCode(HttpStatus.OK.value())
                .data("Best Practice use builder()")
                .build(), HttpStatus.OK);
        return responseEntity;
 */
        return new ResponseEntity<>(MyResponseBuilder.builder()
                .statusCode(HttpStatus.OK.value())
                .data("USE builder() | Best Practice")
                .build(), HttpStatus.OK);
    }

    // Keep data as key-value pair | MAP | builder() | Best Practice
    @GetMapping("test12")
    public ResponseEntity<MyResponseBuilder2> test12() {

        return new ResponseEntity<>(MyResponseBuilder2.builder()
                .statusCode(HttpStatus.OK.value())
                .data("message", "Keep data as key-value pair | MAP | builder() | Best Practice")
                .build(), HttpStatus.OK);
    }


    // Another way to SENT Response
    @GetMapping("test21")
    public ResponseEntity<?> test91() {
        return ResponseEntity.ok("Another way to SENT Response");
    }

    // Another way to SENT Custom DTO
    @GetMapping("test22")
    public ResponseEntity<?> test101() {
        return ResponseEntity.ok(new MyResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Another way to SENT Custom DTO"
        ));
    }

    // SENT BAD Request body
    @GetMapping("test23")
    public ResponseEntity<?> test111() {
        return ResponseEntity.badRequest().body(new MyResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "SENT BAD Request body"
        ));
    }

    // Previous END POINT
    @GetMapping("/example")
    public ResponseEntity<Map<String, Object>> getExampleData1() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("responseCode", HttpStatus.OK.value());
        response.put("data", "Example data goes here");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/example2")
    public ResponseEntity<MyResponse> getExampleData2() {
        MyResponse response = new MyResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Example2 data goes here"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
