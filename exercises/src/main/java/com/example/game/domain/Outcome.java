package com.example.game.domain;

import com.example.game.player.Player;

import java.util.List;

public interface Outcome {
    boolean isDecided();

    // decided のときのみ意味がある
    List<Player> winners();
    List<Player> losers();

    // no-contest のときのみ意味がある
    NoContestReason reason();

    enum NoContestReason {
        SAME_HANDS,      // 全員同じ手
        ALL_THREE_HANDS  // グー・チョキ・パーが全て出た
    }
}