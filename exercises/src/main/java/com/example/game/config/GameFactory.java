package com.example.game.config;

import com.example.game.game.JankenGame;
import com.example.game.io.ConsoleIO;
import com.example.game.judge.Judge;
import com.example.game.judge.MultiPlayerJudge;
import com.example.game.judge.TwoPlayerJudge;
import com.example.game.player.CpuPlayer;
import com.example.game.player.HumanPlayer;
import com.example.game.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class GameFactory {

    private GameFactory() {
        // インスタンス化させない
    }

    /**
     * アプリ起動時の「組み立て役」。
     * - I/O の生成
     * - 人数入力（検証含む）
     * - Player 構築（Human 1 + CPU n-1）
     * - Judge 選択（2人 or 3人以上）
     * - JankenGame に注入して返す
     */
    public static JankenGame create(Scanner sc) {
        ConsoleIO io = new ConsoleIO(sc);

        int n = io.readIntInRange(
                "プレイヤー人数を入力してください（2以上）: ",
                2,
                99
        );

        List<Player> players = createPlayers(n, io);

        Judge judge = (n == 2)
                ? new TwoPlayerJudge()
                : new MultiPlayerJudge();

        return new JankenGame(players, judge, io);
    }

    /**
     * Human 1人 + CPU (n-1) 人を生成。
     * Humanは入力が必要なので ConsoleIO を渡す設計にするのが簡単。
     */
    private static List<Player> createPlayers(int n, ConsoleIO io) {
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("You", io)); // HumanはI/O依存

        for (int i = 1; i <= n - 1; i++) {
            players.add(new CpuPlayer("CPU" + i));
        }
        return players;
    }
}