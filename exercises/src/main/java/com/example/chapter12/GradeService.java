package com.example.chapter12;

class GradeService {
    public static String evaluate(int score) {
        Grade grade = Grade.fromScore(score);

        return String.format("点数: %d → 評価: %s, 合否: %s, GPA:%.1f",
                score,
                grade.getJpName(),
                grade.getisPassed() ? "pass" : "fail",
                grade.getGpa());
    }
}
//"点数: X → 評価: 優, 合否: pass, GPA: 4.0"