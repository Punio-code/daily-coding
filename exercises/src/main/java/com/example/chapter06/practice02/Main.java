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
 */
public class Main {
  public static void main(String[] args) {
    // ★まずは現状出力（完成後もこの出力と完全一致させること）
    int daysLate = 3;
    printOverdueFine("BOOK",  daysLate);
    printOverdueFine("COMIC", daysLate);
    printOverdueFine("DVD",   daysLate);

    // 以下の形に書き換える。
    // Book book = new Book();
    // Comic comic = new Comic();
    // Dvd dvd = new Dvd();
    // System.out.println("[" + book.name()  + "] 延滞" + daysLate + "日 → " + book.calcFine(daysLate)  + "円");
    // System.out.println("[" + comic.name() + "] 延滞" + daysLate + "日 → " + comic.calcFine(daysLate) + "円");
    // System.out.println("[" + dvd.name()   + "] 延滞" + daysLate + "日 → " + dvd.calcFine(daysLate)   + "円");
  }

  // ======（保守性が悪い現行実装：Main 内の if-else 依存）======
  private static void printOverdueFine(String code, int daysLate) {
    String name = name(code);
    int fine = calcFine(code, daysLate);
    System.out.println("[" + name + "] 延滞" + daysLate + "日 → " + fine + "円");
  }

  private static String name(String code) {
    if ("BOOK".equals(code))  return "本";
    else if ("COMIC".equals(code)) return "コミック";
    else if ("DVD".equals(code))   return "DVD";
    throw new IllegalArgumentException("未知の種類: " + code);
  }

  private static int calcFine(String code, int daysLate) {
    if ("BOOK".equals(code)) {
      return daysLate * 10;                  // 本：10円/日
    } else if ("COMIC".equals(code)) {
      return Math.max(daysLate - 1, 0) * 20; // コミック：1日目無料、以降20円/日
    } else if ("DVD".equals(code)) {
      return Math.min(daysLate * 100, 500);  // DVD：100円/日、上限500円
    }
    throw new IllegalArgumentException("未知の種類: " + code);
  }
}
