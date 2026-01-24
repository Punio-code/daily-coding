package com.example.game.io;

import com.example.game.io.Validators;

import java.util.Scanner;

public class ConsoleIO {

    private final Scanner sc;

    public ConsoleIO(Scanner sc) {
        this.sc = sc;
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    /**
     * プロンプトを表示し、min〜max の整数が入力されるまで再入力させる。
     * - 数字以外 → エラー表示して再入力
     * - 範囲外   → エラー表示して再入力
     */
    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (!Validators.isNonNegativeInteger(input)) {
                System.out.println(min + "〜" + max + "のいずれかの整数を入力してください");
                continue;
            }

            int value;
            try {
                value = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // 桁数が大きすぎる等（int範囲外）
                System.out.println(min + "〜" + max + "のいずれかの整数を入力してください");
                continue;
            }

            if (!Validators.isInRange(value, min, max)) {
                System.out.println(min + "〜" + max + "のいずれかの整数を入力してください");
                continue;
            }

            return value;
        }
    }
}