package com.example.game.domain;

import com.example.game.player.Player;

import java.util.List;


public final class NoContestOutcome implements Outcome {

    private final NoContestReason reason;

    public NoContestOutcome(NoContestReason reason) {
        this.reason = reason;
    }

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

    @Override
    public NoContestReason reason() {
        return reason;
    }
}