package com.example.game.domain;

import com.example.game.player.Player;

import java.util.List;


public record NoContestOutcome(NoContestReason reason) implements Outcome {

    @Override
    public boolean isDecided() {
        return false;
    }

    @Override
    public List<Player> winners() {
        return List.of();
    }

    @Override
    public List<Player> losers() {
        return List.of();
    }
}