package com.example.game.player;

import com.example.game.domain.Hand;

public interface Player {
    String getName();
    Hand chooseHand();
}