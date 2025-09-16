package com.example.chapter09.practice05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 予約を行う予約サービスを表現するクラス。
 */
public class ReservationService {
  // テストの再現性を高めるため「今日」は固定日付にしておく。
  static final LocalDate TODAY = LocalDate.of(2025, 9, 17);

  /**
   * 予約を作成して返す。
   *
   * @param checkIn チェックイン日
   * @param checkOut チェックアウト日
   * @return 予約
   */
  public Reservation reserve(LocalDate checkIn, LocalDate checkOut) {

    // ガード1: 逆順入力は例外にする
    if (checkOut.isBefore(checkIn)) { // 修正。自動入れ替えではなく、逆順は例外送出とする仕様のため、入れ替え処理を例外送出に修正。
      throw new InvalidStayDatesException(
          "不正な宿泊日です: チェックアウトはチェックインより後である必要があります。"); // 修正。自動補正と警告出力を廃止し、指定メッセージで例外送出に修正。
    }

    // ガード2: 過去日のチェックインは例外にする
    if (checkIn.isBefore(TODAY)) { // 修正。過去日を本日に丸める仕様から、例外送出に変更。
      throw new PastDateBookingException(
          "過去日付での予約はできません: チェックイン " + checkIn + " は本日 " + TODAY + " より過去です。"); // 修正。自動補正と警告出力を廃止し、指定メッセージで例外送出。
    }

    int nights = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    return new Reservation(checkIn, checkOut, nights);
  }
}