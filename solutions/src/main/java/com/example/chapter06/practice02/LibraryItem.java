package com.example.chapter06.practice02;

/**
 * 図書館アイテムを表す抽象クラス。
 */
public abstract class LibraryItem {

  /**
   * 表示名を返す。
   *
   * @return 表示名
   */
  public abstract String name();

  /**
   * 1日あたりの延滞料金（円）を返す。
   *
   * @return 1日あたりの延滞料金（円）
   */
  public abstract int dailyFine();

  /**
   * 指定の延滞日数、延滞していた場合の延滞料金を返す。
   *
   * @param daysLate 延滞日数
   * @return 延滞料金
   */
  public int calcFine(int daysLate) {
    return daysLate * dailyFine();
  }
}