package com.example.chapter08.practice03;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 【問題03：自習室チェックイン（Set の基本操作）】
 * これは自習室（全10席）で、座席番号のチェックイン／キャンセルを管理するプログラムです。
 * 次の順に処理を行います。
 * (1) 初期の着席者（席: 2, 3, 5）を登録する。
 * (2) 現在の状況を表示する。
 * (3) チェックイン（席: 3, 7, 11）を試す。
 * (4) 再度状況を表示する。
 * (5) キャンセル（席: 5）を行う。
 * (6) 最後に状況を表示する。
 *
 * しかし、未実装やロジック上の不具合があり、期待通りの出力になっていません。
 * 下の「▼指示」に従って修正し、「▼期待される出力」の通りに動作させてください。
 *
 * ▼現在の出力（このまま実行した場合）
 * === 自習室チェックイン（初期） ===
 * 着席中: 3件
 *  - [2]
 *  - [3]
 *  - [5]
 * 空席数: 7席
 * ---- チェックイン ----
 * 席[3] を予約しました。
 * 席[7] を予約しました。
 * 席[11] を予約しました。
 * === 現在の状態 ===
 * 着席中: 5件
 *  - [2]
 *  - [3]
 *  - [5]
 *  - [7]
 *  - [11]
 * 空席数: 5席
 * ---- キャンセル ----
 * 席[5] は予約されていません。
 * === 現在の状態 ===
 * 着席中: 5件
 *  - [2]
 *  - [3]
 *  - [5]
 *  - [7]
 *  - [11]
 * 空席数: 5席
 *
 * ▼期待される出力（正しく修正できた場合の例）
 * === 自習室チェックイン（初期） ===
 * 着席中: 3件
 *  - [2]
 *  - [3]
 *  - [5]
 * 空席数: 7席
 * ---- チェックイン ----
 * 席[3] はすでに予約済みです。
 * 席[7] を予約しました。
 * 席[11] は無効な席番号です。
 * === 現在の状態 ===
 * 着席中: 4件
 *  - [2]
 *  - [3]
 *  - [5]
 *  - [7]
 * 空席数: 6席
 * ---- キャンセル ----
 * 席[5] の予約を取り消しました。
 * === 現在の状態 ===
 * 着席中: 3件
 *  - [2]
 *  - [3]
 *  - [7]
 * 空席数: 7席
 *
 * ▼指示
 * ・チェックイン処理の不具合を修正する。
 *    - 範囲チェック（1～TOTAL_SEATS 以外は受け付けない）
 *    - 重複チェック（add の戻り値で判定し、重複なら「すでに予約済み」）
 * ・キャンセル処理の不具合を修正する。
 *    - 座席番号で remove し、成功/失敗メッセージを正しく出す。
 * ・空席数：TOTAL_SEATS - 予約済みサイズ で計算し、無効番号は数に含めない（＝無効は登録させない）。
 *
 * ▼ヒント
 * ・addの戻り値がtrueのときは追加できたことを意味し、falseのときはすでにその要素が存在していることを意味する。
 * ・removeの戻り値がtrueのときは削除できたことを意味し、falseのときはすでにその要素が存在しないことを意味する。
 * ・範囲は if (n < 1 || n > TOTAL_SEATS) で弾く。
 *
 * ▼ねらい（学習項目）
 * ・Set の基本操作：add / remove / contains / size / isEmpty
 * ・バリデーション（範囲チェック）とメッセージ分岐
 */
public class Main {
  /**
   * 自習室の総席数（1～TOTAL_SEATS が有効）
   */
  private static final int TOTAL_SEATS = 10;

  public static void main(String[] args) {
    Set<Integer> reserved = new LinkedHashSet<>();

    // (1) 初期の着席者（席: 2, 3, 5）を登録する。
    addInitialReservations(reserved);

    // (2) 現在の状況を表示する。
    System.out.println("=== 自習室チェックイン（初期） ===");
    printStatus(reserved);

    // (3) チェックイン（席: 3, 7, 11）を試す。
    System.out.println("---- チェックイン ----");
    checkIn(reserved, 3);
    checkIn(reserved, 7);
    checkIn(reserved, 11);

    // (4) 再度状況を表示する。
    System.out.println("=== 現在の状態 ===");
    printStatus(reserved);

    // (5) キャンセル（席: 5）を行う。
    System.out.println("---- キャンセル ----");
    boolean canceled = cancel(reserved, 5);
    if (canceled) {
      System.out.println("席[5] の予約を取り消しました。");
    } else {
      System.out.println("席[5] は予約されていません。");
    }

    // (6) 最後に状況を表示する。
    System.out.println("=== 現在の状態 ===");
    printStatus(reserved);
  }

  /**
   * 初期の着席者を登録する。
   *
   * @param reserved 予約済み座席番号のSet
   */
  private static void addInitialReservations(Set<Integer> reserved) {
    reserved.add(2);
    reserved.add(3);
    reserved.add(5);
  }

  /**
   * 指定された座席番号でチェックインする。
   * ・指定された座席番号が範囲外（1～10以外）の場合 → 「席[〇] は無効な席番号です。」と表示する。
   * ・指定された座席番号が既に Set 内に存在する場合 → 「席[〇] はすでに予約済みです。」と表示する。
   * ・上記以外（追加成功）の場合 → 「席[〇] を予約しました。」と表示する。
   *
   * @param reserved 予約済み座席番号のSet
   * @param seatNo   座席番号
   */
  private static void checkIn(Set<Integer> reserved, int seatNo) {
    if (seatNo < 1 || seatNo > TOTAL_SEATS) { // 追加。1～TOTAL_SEATS の範囲チェックという仕様のため、無効番号は登録せずに弾くよう追加。
      System.out.println("席[" + seatNo + "] は無効な席番号です。"); // 追加。範囲外はエラーメッセージを表示する仕様のため、文言を追加。
      return; // 追加。無効番号は以降の処理を行わない仕様のため、早期リターンを追加。
    }
    boolean added = reserved.add(seatNo); // 修正。重複を物理的に防ぐ仕様のため、無条件 add から戻り値で可否を判定する処理に修正。
    if (added) {
      System.out.println("席[" + seatNo + "] を予約しました。"); // 修正。成功時のみ成功メッセージを出す仕様のため、修正。
    } else {
      System.out.println("席[" + seatNo + "] はすでに予約済みです。"); // 追加。重複時は警告メッセージを表示する仕様のため、分岐を追加。
    }
  }

  /**
   * 指定された座席番号が「予約済み座席番号のSet」内に存在する場合だけ、予約を取り消す。
   *
   * @param reserved 予約済み座席番号のSet
   * @param seatNo   キャンセルしたい座席番号
   * @return 取り消しに成功した場合は true、存在しない場合は false
   */
  private static boolean cancel(Set<Integer> reserved, int seatNo) {
    if (reserved.contains(seatNo)) { // 修正。存在確認の仕様のため、size 比較ではなく contains に修正。
      return reserved.remove(seatNo);
    }
    return false;
  }

  /**
   * 現在の着席状況を表示する。
   *
   * @param reserved 予約済み座席番号のSet
   */
  private static void printStatus(Set<Integer> reserved) {
    System.out.println("着席中: " + reserved.size() + "件");
    for (int n : reserved) {
      System.out.println(" - [" + n + "]");
    }
    int free = TOTAL_SEATS - reserved.size();
    System.out.println("空席数: " + free + "席");
  }
}