package com.example.chapter01;

/*
  【問題07：テーマパークの入場料金（1本のプログラムで条件分岐を自作してみよう）】

  ▼やりたいこと
    年齢・天気・クーポンの有無などから、最終的な入場料金を出したい。

  ▼料金ルール
   （１）基本料金（年齢帯ごと）
       0～5歳: 0円（乳幼児） / 6～12歳: 2000円（こども） / 13～64歳: 4000円（おとな） / 65歳以上: 2500円（シニア）

   （２）割引（基本料金が 0円でないときだけ適用する割引）
       - 雨の日（isRain == true）の場合：
           ・雨の日クーポンを持っている（hasCoupon == true）   → 30% 引き
           ・雨の日クーポンを持っていない（hasCoupon == false） → 10% 引き

       - 雨でない（isRain == false）場合：
           ・平日（day変数が"平日"）かつ 入場時間が15時以降（entryHour >= 15） → 20% 引き
           ・それ以外 → 割引なし

   （３）小数点は切り捨て（intへのキャストでOK）

  ▼指示
    ・年齢帯の決定：if～else if を使うこと。
    ・基本料金の決定：switch式 を使うこと（switch 文ではなく式）。
    ・割引判定：if のネスト を使うこと（雨→その中でクーポン）。
    ・出力形式は「最終価格: XXXX円」。

  ▼この入力での期待される出力
    最終価格: 3600円
    （理由：20歳なので、おとな料金である4000円、さらに雨＆クーポンを持っていないので10%引き、結果として3600円）

  ▼実装ポイント
    ・年齢帯を if/else if で決定 → そのラベルを switch式で料金に変換。
    ・割引は basePrice > 0 のときだけ適用。雨→（ネスト）クーポンの順に判定。
    ・(int)(価格 * 割引率) で小数点を切り捨てる。
*/
public class Kadai07 {

  public static void main(String[] args) {

    final int age = 20;               // 年齢
    final String day = "平日";         // "平日" or "土日"
    final int entryHour = 10;         // 入場時刻（0～23）
    final boolean isRain = true;      // 雨が降っているか
    final boolean hasCoupon = false;  // 雨の日クーポンを持っているか

    String ageGroupName; // 例: "乳幼児" | "こども" | "おとな" | "シニア"

    // 追加: 年齢帯の決定
    if (age <= 5) {
      ageGroupName = "乳幼児";
    } else if (age <= 12) {
      ageGroupName = "こども";
    } else if (age <= 64) {
      ageGroupName = "おとな";
    } else { // 65歳以上
      ageGroupName = "シニア";
    }

    // 追加: 基本料金の決定（switch式）
    int basePrice = switch (ageGroupName) {
      case "乳幼児" -> 0;
      case "こども" -> 2000;
      case "おとな" -> 4000;
      case "シニア" -> 2500;
      default -> 0;
    };

    int finalPrice = basePrice;

    // 追加: 割引の適用（if のネスト）
    if (finalPrice > 0) { // 0円のときは割引なし
      // 雨が降っているか
      if (isRain) {
        // 雨の日クーポンを持っているか否かで分岐（ネスト）する
        if (hasCoupon) {
          finalPrice = (int) (finalPrice * 0.7); // 30%引き
        } else {
          finalPrice = (int) (finalPrice * 0.9); // 10%引き
        }
      } else {
        // 雨でない場合は、平日かつ15時以降なら20%引き
        if ("平日".equals(day) && entryHour >= 15) {
          finalPrice = (int) (finalPrice * 0.8); // 20%引き
        }
      }
    }

    System.out.println("最終価格: " + finalPrice + "円");
  }
}