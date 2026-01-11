package chapter01;

/*
  【問題05：月から季節を表示せよ（仕様通りに switch文で実装）】
  月（1～12）から季節を表示するプログラムです。季節の分け方は次の通りです。
    3,4,5  → 春
    6,7,8  → 夏
    9,10,11→ 秋
    12,1,2 → 冬
    上記以外 → 不明

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  季節: 秋

  ▼期待される出力結果
  季節: 冬

  ▼指示
  ・下の if～else の連続を switch文 に書き換えて、仕様通りの季節を表示してください。
  ・switch では case を複数並べて、同じ処理にまとめてもOKです。
  ・if～else は使わないこと（switch + case + default を用いる）。

  ▼修正ポイント
  元の if/else では 9〜12 を「秋」にしていたため、12月が誤って秋になっていた。
  switch文で 12,1,2 を同じケースにまとめ、「冬」に分類する。
*/
public class Kadai05 {

  public static void main(String[] args) {
    final int month = 12;

    String season;

    // 修正：if/else をやめ、switch文で季節を判定
    switch (month) {
      case 3:
      case 4:
      case 5:
        season = "春";
        break;
      case 6:
      case 7:
      case 8:
        season = "夏";
        break;
      case 9:
      case 10:
      case 11:
        season = "秋";
        break;
      case 12:
      case 1:
      case 2:
        season = "冬";
        break;
      default:
        season = "不明";
    }

    System.out.println("季節: " + season);
  }
}