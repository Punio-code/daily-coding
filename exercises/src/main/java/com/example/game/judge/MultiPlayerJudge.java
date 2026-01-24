package com.example.game.judge;

import com.example.game.domain.DecidedOutcome;
import com.example.game.domain.Hand;
import com.example.game.domain.NoContestOutcome;
import com.example.game.domain.Outcome;
import com.example.game.player.Player;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiPlayerJudge implements Judge {

    @Override
    public Outcome judge(Map<Player, Hand> choices) {
        if (choices.size() < 3) {
            throw new IllegalArgumentException("MultiPlayerJudge requires 3+ players.");
        }

        Set<Hand> used = EnumSet.noneOf(Hand.class);
        used.addAll(choices.values());

        if (used.size() == 1) {
            return new NoContestOutcome(Outcome.NoContestReason.SAME_HANDS);
        }
        if (used.size() == 3) {
            return new NoContestOutcome(Outcome.NoContestReason.ALL_THREE_HANDS);
        }

        // used.size() == 2 の場合：勝つ手を決める
        List<Hand> pair = used.stream().toList();
        Hand a = pair.get(0);
        Hand b = pair.get(1);

        Hand winningHand = a.beats(b) ? a : b;

        List<Player> winners = choices.entrySet().stream()
                .filter(e -> e.getValue() == winningHand)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Player> losers = choices.entrySet().stream()
                .filter(e -> e.getValue() != winningHand)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return new DecidedOutcome(winners, losers);
    }
}