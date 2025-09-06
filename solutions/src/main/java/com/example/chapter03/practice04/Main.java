package com.example.chapter03.practice04;

/**
 * 【問題04：ピザの残りスライスを正しく管理しよう（クラスを1から作成／コンストラクタでガード＋自作メソッド）】
 *
 * これは、ピザの箱（PizzaBox）に残っているスライス数（0～8切れ）を管理するプログラムです。
 * PizzaBox クラスは存在しないので、あなたが 1 から作ってください。
 *
 * ▼現在の状態（このプログラムをそのまま実行した場合）
 * コンパイルエラー（PizzaBox クラスが見つからない）
 *
 * ▼期待される出力結果
 * 残り: 6切れ
 * 残り: 0切れ
 *
 * ▼指示
 * ・この Main の修正は不要です。
 * ・この Main が配置されているパッケージと同じパッケージに、新しいクラス PizzaBox を作成してください。
 * ・クラス名：public class PizzaBox
 * ・フィールド：private int slices;   // 残りスライス数（0～8）
 * ・コンストラクタ：public PizzaBox(int initialSlices)
 *    - ガード処理を実装する（0 未満は 0、8 超えは 8、それ以外はそのまま代入）
 * ・メソッド
 *    - public void eat(int count)
 *        メソッドの仕様：count（0 以上）だけスライスを減らす。結果は 0 未満にならないように 0 で止める。
 *              count < 0 が来た場合は何もしなくてよい。
 *    - public String label()
 *        メソッドの仕様：「残り: X切れ」の形式で返す（例：残り: 6切れ）
 */
class Main {
  public static void main(String[] args) {
    // ケース1：初期値 10 → コンストラクタのガードで 8 に修正 → 2 切れ食べて 6
    PizzaBox box1 = new PizzaBox(10);
    box1.eat(2);
    System.out.println(box1.label()); // 期待：残り: 6切れ

    // ケース2：初期値 1 → 3 切れ食べる（0 未満にしない）→ 0
    PizzaBox box2 = new PizzaBox(1);
    box2.eat(3);
    System.out.println(box2.label()); // 期待：残り: 0切れ
  }
}