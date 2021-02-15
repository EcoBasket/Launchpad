package com.launchpad.demo.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leaderboard {

    @Singular
    private List<LeaderboardUser> leaderboardUsers;
}
