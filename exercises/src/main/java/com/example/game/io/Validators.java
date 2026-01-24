package com.example.game.io;

public final class Validators {

    private Validators() {
    }

    // 「負号なし整数」判定（0, 1, 2 ...）
    public static boolean isNonNegativeInteger(String s) {
        return s != null && s.matches("\\d+");
    }

    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}