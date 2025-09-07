package com.example.chapter06.practice02;

/**
 * コミッククラス。
 */
public class Comic extends LibraryItem {
  @Override
  public String name() {
    return "コミック";
  }

  @Override
  public int dailyFine() {
    return 20;
  }

  @Override
  public int calcFine(int daysLate) {
    return Math.max(daysLate - 1, 0) * dailyFine();
  }
}
