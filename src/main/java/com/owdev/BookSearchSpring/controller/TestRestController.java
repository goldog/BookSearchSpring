package com.owdev.BookSearchSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    
    
    @GetMapping("test-value")
    public String getTestValue() {
        String testValue = "테스트 값2";
       
        return testValue;
    }

}
