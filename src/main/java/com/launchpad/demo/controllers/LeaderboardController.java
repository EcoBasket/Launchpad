package com.launchpad.demo.controllers;

import com.launchpad.demo.models.Leaderboard;
import com.launchpad.demo.services.LeaderboardService;
import com.launchpad.demo.util.AmazonExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @Autowired
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/leaderboard/{id}")
    public ResponseEntity<Leaderboard> getLeaderboard(@PathVariable(name = "id") String id) {
        return AmazonExceptionHandler.handle(() -> ResponseEntity.ok(leaderboardService.getLeaderboard(id)));
    }
}
