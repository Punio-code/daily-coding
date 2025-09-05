package com.example.chapter01;

/*
  【問題02：電車運賃を計算せよ（if / else if / else と条件の優先順位）】
  これは、年齢と休日フラグに応じて電車運賃を計算するプログラムです。
  料金ルールは次の通り（小数点は最後に「10円未満切り捨て」で丸める。例えば、453円は450円とする。）
    1) 0〜5歳：無料（0円）
    2) 6〜12歳：小児運賃 = 基本運賃の50%
    3) 13〜64歳：大人運賃 = 基本運賃そのまま
    4) 65歳以上：シニア運賃 = 基本運賃の20%引き（= 80%）

  さらに、休日（holiday == true）の場合は、上記で求めた年齢別運賃から
  追加で 10% 引きする（ただし無料はそのまま 0円）。

  しかし現在のコードにはバグがあり、想定と異なる運賃が出力されています。

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  運賃: 460円

  ▼期待される出力結果
  運賃: 370円

  ▼指示
  ・if / else if / else の分岐順序と条件式を修正し、期待される出力になるようにしてください。
  ・定数の値（基本運賃・年齢・休日フラグ）は変更しないこと。
  ・丸め方（10円未満切り捨て）はそのままにすること。（修正不要）
*/
public class Kadai02 {

  public static void main(String[] args) {
    final int baseFare = 520;     // 基本運賃（円）
    final int age = 65;           // 年齢
    final boolean holiday = true; // 休日フラグ

    int fare; // 計算後の運賃（円）

    // 年齢別の運賃計算
    if (age <= 5) {
      fare = 0;
    } else if (age >= 13) {
      fare = baseFare;
    } else if (age >= 6) {
      fare = (int) (baseFare * 0.5);
    } else if (age >= 65) {
      fare = (int) (baseFare * 0.8);
    } else {
      fare = baseFare;
    }

    // 休日割引（無料は割引しない）
    if (holiday && fare > 0) {
      fare = (int) (fare * 0.9); // 10% 引き
    }

    // 最後に10円未満を切り捨てる（例：468 → 460）
    fare = (fare / 10) * 10;

    System.out.println("運賃: " + fare + "円");
  }
}
