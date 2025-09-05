package com.example.chapter01;

/*
  【問題04：おこづかいランク（if文 → 三項演算子に書き換え）】
  これは、おこづかい金額（amount）からランクを表示するプログラムです。

  仕様：
    ・1000円より少ない … ランクA
    ・1000円以上 … ランクS

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  ランク: A

  ▼期待される出力結果
  ランク: S

  ▼指示
  ・下の「if ～ else」の1箇所を、同じ意味になるよう 三項演算子 で書き換えてください。
  ・同時に、条件式も仕様通りになるように修正してください。（現在だと、1000円がAランクとして出力されてしまいます）
*/
public class Kadai04 {

  public static void main(String[] args) {
    final int amount = 1000;

    // 以下の条件式の間違いを正し、また三項演算子に書き換えてください。
    String rank;
    if (amount > 1000) {
      rank = "S";
    } else {
      rank = "A";
    }

    System.out.println("ランク: " + rank);
  }
}