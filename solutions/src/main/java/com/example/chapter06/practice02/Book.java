package com.example.chapter06.practice02;

/**
 * 本クラス。
 */
public class Book extends LibraryItem {
  @Override
  public String name() {
    return "本";
  }

  @Override
  public int dailyFine() {
    return 10;
  }
}
