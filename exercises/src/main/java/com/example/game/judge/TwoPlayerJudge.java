package com.example.game.judge;

import com.example.game.domain.DecidedOutcome;
import com.example.game.domain.Hand;
import com.example.game.domain.NoContestOutcome;
import com.example.game.domain.Outcome;
import com.example.game.player.Player;

import java.util.List;
import java.util.Map;

public class TwoPlayerJudge implements Judge {

    @Override
    public Outcome judge(Map<Player, Hand> choices) {
        if (choices.size() != 2) {
            throw new IllegalArgumentException("TwoPlayerJudge requires exactly 2 players.");
        }

        List<Map.Entry<Player, Hand>> entries = choices.entrySet().stream().toList();
        Player p1 = entries.get(0).getKey();
        Hand h1 = entries.get(0).getValue();
        Player p2 = entries.get(1).getKey();
        Hand h2 = entries.get(1).getValue();

        if (h1 == h2) {
            return new NoContestOutcome(Outcome.NoContestReason.SAME_HANDS);
        }

        if (h1.beats(h2)) {
            return new DecidedOutcome(List.of(p1), List.of(p2));
        } else {
            return new DecidedOutcome(List.of(p2), List.of(p1));
        }
    }
}