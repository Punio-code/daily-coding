package com.example.chapter06.practice02;

/**
 * DVDクラス。
 */
public class Dvd extends LibraryItem {
  @Override
  public String name() {
    return "DVD";
  }

  @Override
  public int dailyFine() {
    return 100;
  }

  @Override
  public int calcFine(int daysLate) {
    return Math.min(daysLate * dailyFine(), 500);
  }
}
