package com.launchpad.demo.services;

import com.launchpad.demo.models.Leaderboard;

public interface LeaderboardService {

    Leaderboard getLeaderboard(String userId);
}
