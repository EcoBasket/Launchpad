package com.launchpad.demo.services;

import com.launchpad.demo.models.HelloWorld;
import com.launchpad.demo.models.dynamodb.LaunchPadDB;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HelloWorldService {

    ResponseEntity<HelloWorld> randomFunction();

    ResponseEntity<List<LaunchPadDB>> testDynamoDB();
}
