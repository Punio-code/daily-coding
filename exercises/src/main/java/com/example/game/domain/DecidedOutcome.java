package com.example.game.domain;

import com.example.game.player.Player;

import java.util.List;

public final class DecidedOutcome implements Outcome {

    private final List<Player> winners;
    private final List<Player> losers;

    public DecidedOutcome(List<Player> winners, List<Player> losers) {
        this.winners = List.copyOf(winners);
        this.losers = List.copyOf(losers);
    }

    @Override
    public boolean isDecided() {
        return true;
    }

    @Override
    public List<Player> winners() {
        return winners;
    }

    @Override
    public List<Player> losers() {
        return losers;
    }

    @Override
    public NoContestReason reason() {
        return null;
    } // decided では未使用
}