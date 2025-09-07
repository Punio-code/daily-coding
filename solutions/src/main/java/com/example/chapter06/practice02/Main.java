package com.example.chapter06.practice02;

/**
 * 【問題02：図書館の延滞料金プログラムを継承で直そう（継承 / オーバーライド / 抽象クラス）】
 *
 * 図書館で「延滞日数」から「延滞料金（円）」を計算して表示します。
 * 現在の実装は "BOOK" / "COMIC" / "DVD" を if-else の列で分岐しており、保守性が悪い状態です。
 * これを、継承・オーバーライド・抽象クラスを使って、同等の出力をするコードに書き換え、保守性を改善してください。
 *
 * ▼現状の出力（このまま実行した例・延滞3日）
 * [本] 延滞3日 → 30円
 * [コミック] 延滞3日 → 40円
 * [DVD] 延滞3日 → 300円
 *
 * ▼完成後も上記と「完全一致」すること（空白や記号も同じ）
 *
 * ▼やること（リファクタ手順）
 *  (1) このパッケージに抽象クラス LibraryItem を作成する。
 *      - String name()          … 表示名を取得する抽象メソッド。
 *      - int    dailyFine()     … 1日あたりの延滞料金（円）を取得する抽象メソッド。
 *      - int    calcFine(int d) … 延滞 d 日の料金（標準：d * dailyFine()）を取得するメソッド。（抽象メソッドではない）
 *  (2) LibraryItem を継承した子クラスを作成する。
 *      - Book  …… 延滞料金: 1日10円
 *      - Comic …… 延滞料金: 1日20円、ただし「1日目は無料」
 *      - Dvd   …… 延滞料金: 1日100円、ただし「上限500円」
 *  (3) 下の if-else に依存したメソッド呼び出しをやめ、
 *      (2)で作成した各クラスを new して個別に表示するコードに置き換える。
 *
 * ▼修正ポイント
 * 延滞料金の計算を各クラスに移動させて責務が分割されたことで以下のメリットがあります。
 * ・構造が把握しやすい。
 * ・将来的な拡張も楽になる。
 * ・仕様変更があったときに、修正箇所の特定も早く行える。
 */
public class Main {
  public static void main(String[] args) {
    int daysLate = 3;

    // 以下を追加。
    Book book = new Book();
    Comic comic = new Comic();
    Dvd dvd = new Dvd();
    System.out.println("[" + book.name()  + "] 延滞" + daysLate + "日 → " + book.calcFine(daysLate)  + "円");
    System.out.println("[" + comic.name() + "] 延滞" + daysLate + "日 → " + comic.calcFine(daysLate) + "円");
    System.out.println("[" + dvd.name()   + "] 延滞" + daysLate + "日 → " + dvd.calcFine(daysLate)   + "円");
  }
}
