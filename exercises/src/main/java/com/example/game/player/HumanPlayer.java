package com.example.game.player;

import com.example.game.domain.Hand;
import com.example.game.io.ConsoleIO;

public class HumanPlayer implements Player {

    private final String name;
    private final ConsoleIO io;

    public HumanPlayer(String name, ConsoleIO io) {
        this.name = name;
        this.io = io;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand chooseHand() {
        int n = io.readIntInRange(
                "手を入力してください（0:グー, 1:チョキ, 2:パー）: ",
                0,
                2
        );
        return Hand.fromInt(n);
    }
}