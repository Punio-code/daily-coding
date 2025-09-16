package com.example.chapter09.practice05;

import java.time.LocalDate;

/**
 * 【問題05：ホテル予約バリデーション（非チェック例外クラスを自作する）】
 * こちらは、チェックイン日とチェックアウト日をもとにホテルの予約を作成して、その予約内容を表示するプログラムです。
 * 現在は、
 * (1) チェックアウト日がチェックイン日より前の場合に日付を入れ替えて保存する。
 * (2) 過去の日付のチェックインを本日に丸め込む。
 * という誤った自動補正を行っています。
 * 本課題では、自動補正は行わないようにして、ビジネスルール違反時に「自作の非チェック例外（RuntimeException 継承）」を投げるように修正してください。
 *
 * ▼期待される出力（修正後）
 * == ケースA: 正常 ==
 * 予約[チェックイン: 2025-10-10, チェックアウト: 2025-10-12, 泊数: 2]
 * == ケースB: 逆順入力 ==
 * [ERROR] 不正な宿泊日です: チェックアウトはチェックインより後である必要があります。
 * == ケースC: 過去日付 ==
 * [ERROR] 過去日付での予約はできません: チェックイン 2025-09-10 は本日 2025-09-17 より過去です。
 *
 * ▼指示（やること）
 * 1. 非チェック例外 InvalidStayDatesException / PastDateBookingException を 新規作成する。
 *    その際 RuntimeException を継承すること。
 * 2. ReservationService#reserve の自動補正ロジックを削除し、以下の条件で例外を送出する。
 *    - checkOut.isBefore(checkIn) のとき
 *      throw new InvalidStayDatesException("不正な宿泊日です: チェックアウトはチェックインより後である必要があります。");
 *    - checkIn.isBefore(TODAY) のとき：
 *      throw new PastDateBookingException("過去日付での予約はできません: チェックイン " + checkIn + " は本日 " + TODAY + " より過去です。");
 * 4. Main の例外ハンドリングは修正不要。
 *
 * ▼ヒント
 * ・非チェック例外はメソッドシグネチャへの throws 宣言が不要です。
 * ・LocalDate の比較は isBefore / isAfter を使います。
 * ・テストの再現性のため、TODAY は 2025-09-17 に固定されています。
 */
public class Main {
  public static void main(String[] args) {
    ReservationService service = new ReservationService();

    System.out.println("== ケースA: 正常 ==");
    try {
      Reservation r = service.reserve(
          LocalDate.of(2025, 10, 10),
          LocalDate.of(2025, 10, 12));
      System.out.println(r);
    } catch (InvalidStayDatesException | PastDateBookingException e) {
      System.out.println("[ERROR] " + e.getMessage());
    }

    System.out.println("== ケースB: 逆順入力 ==");
    try {
      Reservation r = service.reserve(
          LocalDate.of(2025, 10, 12), // 本来は後
          LocalDate.of(2025, 10, 10)); // 本来は前
      System.out.println(r);
    } catch (InvalidStayDatesException | PastDateBookingException e) {
      System.out.println("[ERROR] " + e.getMessage());
    }

    System.out.println("== ケースC: 過去日付 ==");
    try {
      Reservation r = service.reserve(
          LocalDate.of(2025, 9, 10),  // TODAYより過去
          LocalDate.of(2025, 9, 20));
      System.out.println(r);
    } catch (InvalidStayDatesException | PastDateBookingException e) {
      System.out.println("[ERROR] " + e.getMessage());
    }
  }
}