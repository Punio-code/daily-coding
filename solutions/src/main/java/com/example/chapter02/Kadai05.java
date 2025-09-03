package com.example.chapter02;

/*
  【問題05：最初に出てきた偶数を探す】
  あなたは数列の中から「最初に登場する偶数」を探そうとしています。
  配列 numbers の中を先頭から順番に調べ、最初に偶数を見つけたら
  その値を表示して探索を終了してください。

  ▼期待される出力結果（配列 numbers の中に偶数があった場合）
  3
  7
  8
  → 最初の偶数は 8 でした

  ▼期待される出力結果（配列 numbers の中に偶数がなかった場合）
  3
  7
  9
  5
  → 偶数は見つかりませんでした

  ▼指示
  ・while文を使って、配列 numbers を順番に調べてください。
  ・偶数を見つけたら、その値を表示し break で探索を終了してください。
  ・最後まで偶数が見つからなければ「偶数は見つかりませんでした」と表示してください。

  ▼修正ポイント
  ・while文のループ条件
      誤りがちな例: while (i <= numbers.length) と書くと最後に範囲外アクセスになる。
      修正: while (i < numbers.length) として、配列の最後の要素まで正しく走査する。
  ・偶数判定
      誤りがちな例: if (numbers[i] % 2 = 0) としてしまう（代入演算子）。
      修正: if (numbers[i] % 2 == 0) と比較演算子を使って「偶数かどうか」を正しく判定する。
  ・偶数を見つけた時の処理
      修正: 見つけた瞬間に System.out.println("→ 最初の偶数は " + numbers[i] + " でした"); を出力し、return; で main メソッドを終了する。
      これにより「最初の偶数で探索を終了」という要件を満たす。
  ・偶数が見つからなかった場合
      修正: ループを最後まで実行しても return; が呼ばれなければ、ループの後にある System.out.println("→ 偶数は見つかりませんでした"); が実行される。
*/
public class Kadai05 {

  public static void main(String[] args) {
    int[] numbers = {3, 7, 8, 9, 5};

    // ここに while文を書いて完成させる
    int i = 0;
    while (i < numbers.length) {
      System.out.println(numbers[i]);

      if (numbers[i] % 2 == 0) {
        System.out.println("→ 最初の偶数は " + numbers[i] + " でした");
        return; // 見つかったら即終了
      }

      i++;
    }

    // 偶数が最後まで見つからなかった場合のみここが実行される
    System.out.println("→ 偶数は見つかりませんでした");
  }
}