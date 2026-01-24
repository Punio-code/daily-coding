package com.example.game.game;

import com.example.game.domain.Hand;
import com.example.game.domain.Outcome;
import com.example.game.io.ConsoleIO;
import com.example.game.judge.Judge;
import com.example.game.player.Player;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JankenGame {

    private final List<Player> players;
    private final Judge judge;
    private final ConsoleIO io;

    public JankenGame(List<Player> players, Judge judge, ConsoleIO io) {
        this.players = List.copyOf(Objects.requireNonNull(players));
        this.judge = Objects.requireNonNull(judge);
        this.io = Objects.requireNonNull(io);

        if (this.players.size() < 2) {
            throw new IllegalArgumentException("players must be >= 2");
        }
    }

    /**
     * ゲーム進行（不成立なら再戦、決着したら終了）
     */
    public void run() {
        io.println("=== じゃんけんゲーム ===");

        while (true) {
            Map<Player, Hand> choices = collectChoices();      // 全員の手を確定
            Outcome outcome = judge.judge(choices);            // 判定（純粋ロジック想定）

            printRound(choices, outcome);

            if (outcome.isDecided()) {
                return; // 勝敗が付いたら終了
            }

            io.println("あいこです。もう一度！");
            io.println(""); // 見やすさのため空行
        }
    }

    /**
     * 各プレイヤーの手を集める（順番に呼ぶが「同時に確定した」扱い）
     */
    private Map<Player, Hand> collectChoices() {
        Map<Player, Hand> choices = new LinkedHashMap<>();
        for (Player p : players) {
            Hand hand = p.chooseHand();
            if (hand == null) {
                throw new IllegalStateException("chooseHand() returned null: " + p.getName());
            }
            choices.put(p, hand);
        }
        return choices;
    }

    private void printRound(Map<Player, Hand> choices, Outcome outcome) {
        // 参加者の手を表示
        for (Map.Entry<Player, Hand> e : choices.entrySet()) {
            io.println(e.getKey().getName() + " の手: " + e.getValue().label());
        }

        // 結果表示
        if (outcome.isDecided()) {
            io.println("勝者: " + joinNames(outcome.winners()));
            io.println("敗者: " + joinNames(outcome.losers()));
        } else {
            // 不成立の理由を出すならここ（必要ならOutcome側にreasonを持たせる）
            // io.println("不成立: " + outcome.reason());
        }
    }

    private String joinNames(List<Player> ps) {
        return ps.stream().map(Player::getName).reduce((a, b) -> a + ", " + b).orElse("(なし)");
    }
}