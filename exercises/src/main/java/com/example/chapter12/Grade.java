package com.example.chapter12;

import java.util.Arrays;

// * 　列挙子を Excellent（優）, Good（良）, Pass（可）, Fail（不可） の4つとする。

// * ・各列挙子は次の情報を持つこと：

// *   - グレードの日本語名（優, 良, 可, 不可）
// *   - そのグレードの範囲（min〜max の点数）
// *   - 合否（true/false）
// *   - GPA 値（優=4.0、良=3.0、可=2.0、不可=0.0）
// * ・点数を入力して該当する Enum を返すメソッド `Grade.fromScore(int score)` を実装する。
// *   - 例：90点以上=優, 70〜89=良, 60〜69=可, 〜59=不可
// *   - 範囲外の点数（負の値や100超え）は IllegalArgumentException を throw
// * ・GradeServiceのevaluateメソッドでは、`Grade` Enumを使って、期待通りの出力になるように修正する。
// * ・出力は次の形式：
// *   "点数: X → 評価: 優, 合否: pass, GPA: 4.0"
// *
public enum Grade {
    Excellent("優", 90, 100, true, 4.0),
    Good("良", 70, 89, true, 3.0),
    Pass("可", 60, 69, true, 2.0),
    Fail("不可", 0, 59, false, 0.0);

    // 必要な変数
    // *   - グレードの日本語名（優, 良, 可, 不可）
    private final String jpName;
    // *   - そのグレードの範囲（min〜max の点数）
    private final int min;
    private final int max;
    // *   - 合否（true/false）
    private final Boolean isPassed;
    // *   - GPA 値（優=4.0、良=3.0、可=2.0、不可=0.0）
    private final double gpa;

//  getter

    //  コンストラクタ
    Grade(String jpName, int min, int max, Boolean isPassed, double gpa) {
        this.jpName = jpName;
        this.min = min;
        this.max = max;
        this.isPassed = isPassed;
        this.gpa = gpa;
    }

    public static Grade fromScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("点数は 0〜100 の範囲で指定してください :" + score);
        } else {
            return
                    Arrays.stream(Grade.values())
                            .filter(e -> e.contains(score))
                            //結果を1件だけ取って処理を終える
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("点数は 有効な形式で指定してください"));
        }
    }

    public String getJpName() {
        return jpName;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Boolean getisPassed() {
        return isPassed;
    }

    public double getGpa() {
        return gpa;
    }

    //疑似的に範囲を検索している
    private boolean contains(int score) {
        return min <= score && score <= max;
    }
}
