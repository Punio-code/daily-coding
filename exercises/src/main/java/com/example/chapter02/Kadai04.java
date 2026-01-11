package com.example.chapter02;

import java.util.OptionalInt;

/*
  【問題04：ゲームスコアの合計と平均】
  あなたはゲームで5回プレイしました。
  それぞれのスコアが配列 scores に入っています。
  この配列を for文で走査し、合計と平均を計算してください。

  ▼期待される出力結果
  合計: 430
  平均: 86

  ▼指示
  ・for文を自分で書いて、合計を出すこと。
  ・平均は合計を配列の要素数で割ること（整数でOK）。
  ・出力形式は期待される出力に合わせること。
*/
public class Kadai04 {

    public static void main(String[] args) {
        int[] scores = {100, 80, 90, 70, 90};
        int validCount = 0;
        // ここに処理を書いて完成させる
        int sum = 0;
        for (int i : scores) {
            sum += i;
            System.out.println(sum);
            validCount++;
        }
        System.out.println("合計: " + sum);
        OptionalInt avg = validCount == 0 ? OptionalInt.empty() : OptionalInt.of(sum / validCount);
        avg.ifPresentOrElse(v -> System.out.println("平均: " + v), () -> System.out.println("平均: 計算不能"));


    }
}