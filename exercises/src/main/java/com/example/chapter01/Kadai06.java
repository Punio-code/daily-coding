package com.example.chapter01;

/*
  【問題06：信号の色で行動を表示（if文 → switch式に書き換え）】
  信号の色（signal）に応じて、歩行者の行動を表示するプログラムです。

  仕様：
    "GREEN"  → 「進む」
    "YELLOW" → 「注意して進む」
    "RED"    → 「止まる」
    上記以外 → 「不明」

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  行動: 不明

  ▼期待される出力結果
  行動: 止まる

  ▼指示
  ・下の if ～ else の判定を switch式 に書き換えて、仕様通りの文字列を代入してください。
  ・if ～ else は使わないこと。switch文ではなく、switch式 を用いること。
*/
public class Kadai06 {

  public static void main(String[] args) {
    final String signal = "RED";

    // 以下の if ～ else の判定を switch式 に書き換えてください。
    String action;

    if ("GREEN".equals(signal)) {
      action = "進む";
    } else if ("YELLOW".equals(signal)) {
      action = "注意して進む";
    } else if ("RED".equals(signal)) {
      action = "止まる";
    } else {
      action = "不明";
    }

    System.out.println("行動: " + action);
  }
}






