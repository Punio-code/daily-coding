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

  ▼修正ポイント
  元のコードは if (battery >= 30 || hasCharger || outletAvailable) となっており、
  「どれか1つでも true ならプレイ開始」という誤った判定だった。
  正しくは「まず電池を判定し、足りない場合だけ充電器→コンセントの順に条件分岐をネストして判定」する。
*/
public class Kadai03 {

  public static void main(String[] args) {
    final int battery = 15; // 電池残量
    final boolean hasCharger = true; // 充電器はあるか
    final boolean outletAvailable = false; // コンセントは空いているか

    String message; // 出力するメッセージ

    // 修正：段階的に if をネストして判定する
    if (battery >= 30) {
      message = "プレイ開始";
    } else {
      // 充電器はあるか
      if (hasCharger) {
        // 充電器はある → コンセントの空いているか
        if (outletAvailable) {
          message = "充電してからプレイOK";
        } else {
          message = "できません: コンセントが空いていません";
        }
      } else {
        // 充電器がない
        message = "できません: 充電器がありません";
      }
    }

    System.out.println(message);
  }
}