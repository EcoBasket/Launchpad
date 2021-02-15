package com.launchpad.demo.services.impl;

import com.launchpad.demo.models.HelloWorld;
import com.launchpad.demo.models.dynamodb.LaunchPadDB;
import com.launchpad.demo.services.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public ResponseEntity<HelloWorld> randomFunction() {
        return ResponseEntity.ok(new HelloWorld(1, "meters"));
    }

    @Override
    public ResponseEntity<List<LaunchPadDB>> testDynamoDB() {
        return null;
    }
}
