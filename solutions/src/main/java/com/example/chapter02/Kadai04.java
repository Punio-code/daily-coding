package com.example.chapter02;

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

  ▼修正ポイント
  ・ループ処理
      修正: for (int i = 0; i < scores.length; i++) として、先頭から末尾までを走査。
  ・平均値
      誤りの例: 配列の長さで割らずに固定値で割ってしまう。
      修正: sum / scores.length を使うことで配列サイズが変わっても対応可能。
*/
public class Kadai04 {

  public static void main(String[] args) {
    int[] scores = {100, 80, 90, 70, 90};

    // ここに処理を書いて完成させる
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i]; // 加算代入で合計を累積
    }

    // 平均は合計を要素数で割る
    int avg = sum / scores.length;

    System.out.println("合計: " + sum);
    System.out.println("平均: " + avg);
  }
}