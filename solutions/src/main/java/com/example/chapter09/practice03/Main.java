package com.example.chapter09.practice03;


/**
 * 【問題03：時間帯クラスのガード処理を実装しよう（throw new 例外クラス）】
 * この課題では、開始時刻と終了時刻を表す TimeRange クラスの
 * 「コンストラクタのガード処理（不正引数なら例外を投げる）」を実装します。
 *
 * ▼やること（すべて TimeRange のコンストラクタで行うこと）
 * ・以下の条件に違反した場合、いずれも IllegalArgumentException を throw してください。
 *   1) 範囲外チェック：
 *      - start と end は 0〜23 の範囲でなければならない。
 *      - 違反時の例外メッセージ： "start と end は 0〜23 の範囲で指定してください。"
 *   2) 順序チェック：
 *      - start < end を満たさなければならない（等しい・逆転は不可）。
 *      - 違反時の例外メッセージ： "start < end となるように指定してください。"
 *
 * ▼現在の出力（このまま実行した場合の例）
 * 開始時刻：9、終了時刻：17
 * 開始時刻：25、終了時刻：10
 * 開始時刻：22、終了時刻：10
 *
 * ▼期待される出力（正しく実装できた場合の例）
 *  - new TimeRange(9, 17).format()
 *      → "開始時刻：9、終了時刻：17"
 *  - new TimeRange(25, 10)  // 範囲外
 *      → IllegalArgumentException: start と end は 0〜23 の範囲で指定してください。
 *  - new TimeRange(22, 10)  // 順序違反
 *      → IllegalArgumentException: start < end となるように指定してください。
 */
public class Main {
  public static void main(String[] args) {
    System.out.println(new TimeRange(9, 17).format());   // 正常系 → 「開始時刻：9、終了時刻：17」
    System.out.println(new TimeRange(25, 10).format());  // 異常系: 範囲外（0〜23以外）→ 例外スロー
    System.out.println(new TimeRange(22, 10).format());  // 異常系: 順序違反（start >= end）→ 例外スロー
  }
}