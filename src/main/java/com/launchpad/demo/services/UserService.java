package com.launchpad.demo.services;

import com.launchpad.demo.models.RequestBodyUser;
import com.launchpad.demo.models.dynamodb.Score;
import com.launchpad.demo.models.dynamodb.User;

import java.util.Optional;

public interface UserService {

    User createUser(RequestBodyUser user);

    Optional<User> getUser(String id);

    User addFriend(String userId, String friendId);

    User deleteFriend(String userId, String friendId);

    User updateScore(User user, Score score);
}
