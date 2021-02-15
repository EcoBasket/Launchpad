package com.launchpad.demo.dao;

import com.launchpad.demo.models.dynamodb.User;

import java.util.Optional;

public interface UserServiceDao {

    Optional<User> getUser(String id);

    User createUser(User user);

    User updateUser(User updatedUser);
}
