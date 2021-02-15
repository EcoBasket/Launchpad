package com.launchpad.demo.controllers;


import com.launchpad.demo.models.HelloWorld;
import com.launchpad.demo.models.dynamodb.LaunchPadDB;
import com.launchpad.demo.services.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/randomAddress")
    private ResponseEntity<HelloWorld> randomFunction() {
        return service.randomFunction();
    }

    @GetMapping("/testdynamodb")
    private ResponseEntity<List<LaunchPadDB>> testDynamoDB() {
        return service.testDynamoDB();
    }
}
