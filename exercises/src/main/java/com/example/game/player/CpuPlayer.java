package com.example.game.player;

import com.example.game.domain.Hand;

import java.util.Random;

public class CpuPlayer implements Player {

    private final String name;
    private final Random random = new Random();

    public CpuPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand chooseHand() {
        int n = random.nextInt(3); // 0..2
        return Hand.fromInt(n);
    }
}