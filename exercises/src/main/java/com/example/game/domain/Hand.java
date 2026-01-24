package com.example.game.domain;

public enum Hand {
    ROCK("グー"),
    SCISSORS("チョキ"),
    PAPER("パー");

    private final String label;

    Hand(String label) {
        this.label = label;
    }

    public static Hand fromInt(int n) {
        return switch (n) {
            case 0 -> ROCK;
            case 1 -> SCISSORS;
            case 2 -> PAPER;
            default -> throw new IllegalArgumentException("Hand must be 0..2: " + n);
        };
    }

    public String label() {
        return label;
    }

    public boolean beats(Hand other) {
        return (this == ROCK && other == SCISSORS)
                || (this == SCISSORS && other == PAPER)
                || (this == PAPER && other == ROCK);
    }
}