package com.example.chapter12;

class GradeService {
  public static String evaluate(int score) {
    String grade;
    if (score >= 90) {
      grade = "A";
    } else if (score >= 70) {
      grade = "B";
    } else if (score >= 60) {
      grade = "C";
    } else {
      grade = "D";
    }

    return String.format("点数: %d → 評価: %s", score, grade);
  }
}
