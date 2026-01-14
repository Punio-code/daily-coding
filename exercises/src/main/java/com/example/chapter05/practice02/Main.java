package com.example.chapter05.practice02;

import java.util.Random;

/**
 * 【問題02：じゃんけんCPUが毎回グー → ランダムに直す（Random）】
 * CPU の手が毎回「グー」固定になっているプログラムを、
 * 実行するたびに「グー / チョキ / パー」のいずれかがランダムに出るように直してください。
 * <p>
 * ▼現在の出力（このまま実行した場合の一例）
 * CPUの手: グー
 * （毎回グーになる）
 * <p>
 * ▼期待される出力
 * CPUの手: チョキ
 * CPUの手: パー
 * CPUの手: グー
 * …など、実行のたびに変わる
 * <p>
 * ▼指示（ここを直す）
 * 1) Random を使って 0〜2 の整数を1つ作る（nextInt(3)）
 * 2) 0→グー、1→チョキ、2→パー として配列から取り出す
 */
public class Main {
    public static void main(String[] args) {
        String[] hands = {"グー", "チョキ", "パー"};

        //String cpu = "グー"; // この実装だと、毎回CPUの手が「グー」になってしまう
        //なのでランダム処理
        String cpu = hands[new Random().nextInt(hands.length)];
        System.out.println("CPUの手: " + cpu);
    }
}