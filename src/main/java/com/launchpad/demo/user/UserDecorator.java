package com.launchpad.demo.user;

import com.launchpad.demo.models.RequestBodyUser;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.shopping.ScoreProvider;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class UserDecorator {

    public User decorate(RequestBodyUser requestBodyUser) {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .name(requestBodyUser.getName())
                .email(requestBodyUser.getEmail())
                .score(ScoreProvider.buildScoreFrom(0.0D))
                .shoppingListId(UUID.randomUUID().toString())
                .friends(List.of())
                .build();
    }
}
