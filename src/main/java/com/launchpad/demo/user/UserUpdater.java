package com.launchpad.demo.user;

import com.launchpad.demo.models.dynamodb.Score;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.util.ListUtils;

import java.util.List;

public class UserUpdater {

    private final User user;

    public UserUpdater(User user) {
        this.user = user;
    }

    public User addFriend(String friendId) {
        List<String> friends = ListUtils.copyOf(user.getFriends());
        friends.add(friendId);
        user.setFriends(friends);
        return user;
    }

    public User removeFriend(String friendId) {
        List<String> friends = ListUtils.copyOf(user.getFriends());
        friends.remove(friendId);
        user.setFriends(friends);
        return user;
    }

    public User updateScore(Score score) {
        this.user.setScore(score);
        return user;
    }
}
