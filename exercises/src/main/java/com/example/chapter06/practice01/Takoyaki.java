package com.example.chapter06.practice01;

/**
 * たこ焼きの抽象クラス
 */
abstract class Takoyaki {

  /**
   * たこ焼きの基本料金
   */
  private final int base = 400;

  /**
   * トッピングの料金を返す。
   *
   * @return トッピングの料金
   */
  abstract int toppingFee();

  /**
   * たこ焼きの名前を返す。
   *
   * @return たこ焼きの名前
   */
  String displayName() {
    return "たこ焼き";
  }

  /**
   * 合計料金（基本料金＋トッピングの料金）を返す。
   *
   * @return 合計料金（基本料金＋トッピングの料金）
   */
  int total() {
    return base + toppingFee();
  }
}
