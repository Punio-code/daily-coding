package com.example.chapter12.practice01;

import java.util.Arrays;

/**
 * グレードを表すEnum。
 */
public enum Grade {
  EXCELLENT("優", 90, 100, true, 4.0),
  GOOD("良", 70, 89, true, 3.0),
  PASS("可", 60, 69, true, 2.0),
  FAIL("不可", 0, 59, false, 0.0);

  /**
   * グレードの日本語名
   */
  private final String jpName;

  /**
   * 下限点
   */
  private final int min;

  /**
   * 上限点
   */
  private final int max;

  /**
   * 合否
   */
  private final boolean isPassed;

  /**
   * GPA値
   */
  private final double gpa;

  /**
   * コンストラクタ。
   *
   * @param jpName   グレードの日本語名
   * @param min      下限点
   * @param max      上限点
   * @param isPassed 合否
   * @param gpa      GPA値
   */
  Grade(String jpName, int min, int max, boolean isPassed, double gpa) {
    this.jpName = jpName;
    this.min = min;
    this.max = max;
    this.isPassed = isPassed;
    this.gpa = gpa;
  }

  /**
   * グレードの日本語名を返す。
   *
   * @return グレードの日本語名
   */
  public String getJpName() {
    return jpName;
  }

  /**
   * 合否を返す。
   *
   * @return true: 合格, false: 不合格
   */
  public boolean isPassed() {
    return isPassed;
  }

  /**
   * GPA値を返す。
   *
   * @return GPA値
   */
  public double getGpa() {
    return gpa;
  }

  /**
   * 対象の点数が、グレードの範囲内にあるか否かを返す。
   *
   * @param score 対象の点数
   * @return 対象の点数が、グレードの範囲内にあるか否か
   */
  public boolean matches(int score) {
    return min <= score && score <= max;
  }

  /**
   * 点数から適切なGradeを返す。
   * 範囲外は IllegalArgumentException を投げる。
   *
   * @param score 点数
   * @return Grade
   */
  public static Grade fromScore(int score) {
    if (score < 0 || score > 100) {
      throw new IllegalArgumentException(
          "点数は 0〜100 の範囲で指定してください: " + score);
    }

    // values()で全列挙子から該当範囲を探索。
    return Arrays.stream(values())
        .filter(grade -> grade.matches(score))
        .findFirst()
        // ここには来ない想定だが、念のため防御的コード。範囲定義漏れが万が一あった場合にここで検知できる。
        .orElseThrow(() -> new IllegalStateException("定義されていないスコア範囲です: " + score));
  }
}
