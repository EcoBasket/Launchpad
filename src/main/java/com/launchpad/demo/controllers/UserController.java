package com.launchpad.demo.controllers;

import com.launchpad.demo.models.RequestBodyUser;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.services.UserService;
import com.launchpad.demo.util.AmazonExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable(name = "id") String id) {
        return AmazonExceptionHandler.handle(() -> {
            Optional<User> userOptional = userService.getUser(id);

            if (userOptional.isPresent())
                return ResponseEntity.ok(userOptional.get());
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        });
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody RequestBodyUser user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/user/friend/{userId}/{friendId}")
    public ResponseEntity<?> addFriend(@PathVariable(name = "userId") String userId, @PathVariable(name = "friendId") String friendId) {
        return AmazonExceptionHandler.handle(() -> ResponseEntity.ok(userService.addFriend(userId, friendId)));
    }

    @DeleteMapping("/user/friend/{userId}/{friendId}")
    public ResponseEntity<?> deleteFriend(@PathVariable(name = "userId") String userId, @PathVariable(name = "friendId") String friendId) {
        return AmazonExceptionHandler.handle(() -> ResponseEntity.ok(userService.deleteFriend(userId, friendId)));
    }
}
