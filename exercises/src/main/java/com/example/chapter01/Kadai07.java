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
*/
public class Kadai07 {

    public static void main(String[] args) {

        final int age = 20;               // 年齢
        final String day = "平日";         // "平日" or "土日"
        final int entryHour = 10;         // 入場時刻（0～23）
        final boolean isRain = true;      // 雨が降っているか
        final boolean hasCoupon = false;  // 雨の日クーポンを持っているか

        String ageGroupName; // 例: "乳幼児" | "こども" | "おとな" | "シニア"
    /*
        この下に、if ～ else if を使用して、
        age変数の値をもとに、ageGroupName変数に"乳幼児" | "こども" | "おとな" | "シニア" のいずれかを
        代入する処理を書いてください。
    */
        if (age <= 5) {
            ageGroupName = "乳幼児";
        } else if (age <= 12) {
            ageGroupName = "こども";
        } else if (age <= 64) {
            ageGroupName = "おとな";
        } else {
            ageGroupName = "シニア";
        }


    /*
        この下に、switch式 を使用して、
        ageGroupName変数の値をもとに、basePrice変数に基本料金を代入する処理を書いてください。
    */
        int basePrice = switch (ageGroupName) {
            case "乳幼児" -> 0;

            case "こども" -> 2000;

            case "おとな" -> 4000;

            case "シニア" -> 2500;

            default -> 0; // 基本料金
        };




    /*
        この下に、割引の判定処理を書いてください。basePrice が 0 のときは割引しません。
        ▼ヒント
          1) isRain が true（雨）なら：
               - hasCoupon が true  → finalPrice = (int)(finalPrice * 0.7);  // 30%引き
               - hasCoupon が false → finalPrice = (int)(finalPrice * 0.9);  // 10%引き
             ※必ず「雨か？」の if の内側で「クーポンある？」を判定する（if のネスト必須）
          2) isRain が false（雨でない）なら：
               - day が "平日" かつ entryHour >= 15 → finalPrice = (int)(finalPrice * 0.8); // 20%引き
               - それ以外 → 割引なし
    */
        int finalPrice = basePrice;

        if (basePrice != 0) {
            if (isRain) {
                // 雨 → ここでクーポン判定（ネスト必須）
                if (hasCoupon) {
                    finalPrice = (int) (finalPrice * 0.7); // 30%引き
                } else {
                    finalPrice = (int) (finalPrice * 0.9); // 10%引き
                }
            } else {
                // 雨でない
                if ("平日".equals(day) && entryHour >= 15) {
                    finalPrice = (int) (finalPrice * 0.8); // 20%引き
                }
                // それ以外：割引なし
            }
        }


        System.out.println("最終価格: " + finalPrice + "円");
    }
}

//PS C:\gitclone\java-training\exercises\src\main\java\com\example\chapter01> java .\Kadai07.java
//最終価格: 3600円