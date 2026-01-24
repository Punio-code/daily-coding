package com.example.game.judge;

import com.example.game.domain.Hand;
import com.example.game.domain.Outcome;

import java.util.Map;

public interface Judge {

    Outcome judge(Map<com.example.game.player.Player, Hand> choices);
}