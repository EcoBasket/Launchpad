package com.launchpad.demo.models;

import com.launchpad.demo.models.dynamodb.Score;
import com.launchpad.demo.models.dynamodb.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaderboardUser {

    private String id;

    private String name;

    private Integer position;

    private Score score;

    public static LeaderboardUser from(User user, Integer position, Score score) {
        return new LeaderboardUser(user.getId(), user.getName(), position, score);
    }
}
