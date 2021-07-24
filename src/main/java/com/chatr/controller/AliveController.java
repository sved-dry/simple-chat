package com.chatr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController {

    public AliveController() {

    }

    @GetMapping(value = "/alive")
    ResponseEntity<String> get() {
        return ResponseEntity.ok("hi there");
    }
}
