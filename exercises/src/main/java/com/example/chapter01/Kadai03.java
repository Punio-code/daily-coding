package com.example.chapter01;

/*
  【問題03：スマホでゲーム開始できる？（if文のネスト）】
   まず「スマホの電池が足りるか」を確認し、足りなければ「充電器があるか」、
   さらに「コンセントが空いているか」を順番に確認して、
   状況に応じて適切なメッセージを出力したい。

  ルール：
    1) 電池残量（battery） が 30% 以上 → 「プレイ開始」と出力する。
    2) 30% 未満 → 充電器はある？（hasCharger）
         └ 充電器はある → コンセントは空いている？（outletAvailable）
               ・空いている → 「充電してからプレイOK」と出力する。
               ・空いていない → 「できません: コンセントが空いていません」と出力する。
         └ 充電器はない → 「できません: 充電器がありません」と出力する。

   現在、条件を OR でまとめてしまっているため、
   ・battery=15（電池残量が15%）,
   ・hasCharger=true（充電器はある）,
   ・outletAvailable=false（コンセントは空いていない）
   のときは、「プレイ開始」と表示されてしまう。
   ルール通りに出力されるようにしてほしい。

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  プレイ開始

  ▼期待される出力結果
  できません: コンセントが空いていません

  ▼指示
  ・「電池 → 充電器 → コンセント」の順で if をネストして判定し、期待される出力に修正してください。
*/
public class Kadai03 {

  public static void main(String[] args) {
    final int battery = 15; // 電池残量
    final boolean hasCharger = true; // 充電器はあるか
    final boolean outletAvailable = false; // コンセントは空いているか

    String message; // 出力するメッセージ

    // 以下を修正してください。
    if (battery >= 30 || hasCharger || outletAvailable) {
      message = "プレイ開始";
    } else {
      message = "できません: コンセントが空いていません";
    }

    System.out.println(message);
  }
}