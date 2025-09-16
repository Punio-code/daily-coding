package com.example.chapter09.practice05;

import java.time.LocalDate;

/**
 * 予約を表現するクラス。
 */
public class Reservation {
  private final LocalDate checkIn;  // チェックイン日
  private final LocalDate checkOut; // チェックアウト日
  private final int nights;         // 宿泊数

  /**
   * コンストラクタ。
   *
   * @param checkIn チェックイン日
   * @param checkOut チェックアウト日
   * @param nights 宿泊数
   */
  public Reservation(LocalDate checkIn, LocalDate checkOut, int nights) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.nights = nights;
  }

  @Override
  public String toString() {
    return "予約[チェックイン: " + checkIn
        + ", チェックアウト: " + checkOut
        + ", 泊数: " + nights + "]";
  }
}