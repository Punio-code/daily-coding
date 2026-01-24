package com.example.game;

import com.example.game.config.GameFactory;
import com.example.game.game.JankenGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            JankenGame game = GameFactory.create(sc);
            game.run();
        }
    }
}