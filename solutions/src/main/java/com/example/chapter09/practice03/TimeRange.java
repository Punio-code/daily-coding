package com.example.chapter09.practice03;

public class TimeRange {
  private final int start;
  private final int end;

  /**
   * コンストラクタ。
   *
   * @param start 開始時刻（0〜23）
   * @param end   終了時刻（0〜23）
   * @throws IllegalArgumentException 不正な値が渡された場合
   */
  public TimeRange(int start, int end) {
    // 修正。範囲外の値が与えられた場合は例外を投げるように変更。
    if (start < 0 || start > 23 || end < 0 || end > 23) {
      throw new IllegalArgumentException("start と end は 0〜23 の範囲で指定してください。");
    }

    // 修正。開始時刻が終了時刻以上の場合は例外を投げるように変更。
    if (start >= end) {
      throw new IllegalArgumentException("start < end となるように指定してください。");
    }
    this.start = start; // ガード通過後の値のみ、代入するようにした。
    this.end = end;     // ガード通過後の値のみ、代入するようにした。
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