package com.example.chapter12;

class GradeService {
  public static String evaluate(int score) {
    Grade g = Grade.fromScore(score); // 修正。Enumの静的メソッドで評価を取得。

    // 修正。出力形式に従い整形。
    return String.format(
        "点数: %d → 評価: %s, 合否: %s, GPA: %.1f",
        score,
        g.getJpName(),
        g.isPassed() ? "pass" : "fail",
        g.getGpa()
    );
  }
}
