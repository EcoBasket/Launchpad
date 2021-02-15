package com.launchpad.demo.services.impl;

import com.launchpad.demo.models.Leaderboard;
import com.launchpad.demo.models.LeaderboardUser;
import com.launchpad.demo.models.dynamodb.ShoppingList;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.services.LeaderboardService;
import com.launchpad.demo.services.ShoppingListService;
import com.launchpad.demo.services.UserService;
import com.launchpad.demo.util.ComparatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private final UserService userService;

    private final ShoppingListService shoppingListService;

    @Autowired
    public LeaderboardServiceImpl(UserService userService, ShoppingListService shoppingListService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
    }

    @Override
    public Leaderboard getLeaderboard(String userId) {
        User executingUser = getUserAndHandleOptional(userId);

        AtomicInteger positionCounter = new AtomicInteger(1);

        Map<String, User> friends = executingUser.getFriends().stream()
                .map(this::getUserAndHandleOptional)
                .collect(Collectors.toMap(User::getId, u -> u));

        friends.put(executingUser.getId(), executingUser);

        return new Leaderboard(friends.values().stream()
                .map(User::getShoppingListId)
                .map(this::getShoppingListAndHandleOptional)
                .sorted(Comparator.comparingDouble(s -> s.getScore().getScoreAmount()))
                .map(s -> LeaderboardUser.from(
                        friends.get(s.getUserId()),
                        positionCounter.getAndIncrement(),
                        s.getScore())).collect(Collectors.toList()));
    }

    private User getUserAndHandleOptional(String userId) {
        Optional<User> userOptional = userService.getUser(userId);

        if (userOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userOptional.get();
    }

    private ShoppingList getShoppingListAndHandleOptional(String shoppingListId) {
        Optional<ShoppingList> userOptional = shoppingListService.getShoppingList(shoppingListId);

        if (userOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userOptional.get();
    }

}
