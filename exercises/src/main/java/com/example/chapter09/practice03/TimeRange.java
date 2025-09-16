package com.example.chapter09.practice03;

public class TimeRange {
  private final int start;
  private final int end;

  /**
   * コンストラクタ。
   *
   * @param start 開始時刻（0〜23）
   * @param end   終了時刻（0〜23）
   */
  public TimeRange(int start, int end) {
    // ここに仕様通りの挙動になるように、ガード処理を実装してください。
    this.start = start;
    this.end = end;
  }

  /**
   * 開始時刻と終了時刻を表示する。
   *
   * @return 開始時刻と終了時刻
   */
  public String format() {
    return String.format("開始時刻：%d、終了時刻：%d", start, end);
  }
}