package com.example.chapter12;

/**
 * 【問題01：点数を Grade Enum によって評価しよう】
 * この課題では、試験の点数（0〜100点）から成績を判定する処理を
 * 「if 文と文字列」に頼った脆弱な実装から、
 * Enum を用いた堅牢な実装に変更します。
 *
 * ▼やること
 * ・成績を表す Enum `Grade` を作成し、
 * 　列挙子を EXCELLENT（優）, GOOD（良）, PASS（可）, FAIL（不可） の4つとする。
 * ・各列挙子は次の情報を持つこと：
 *   - グレードの日本語名（優, 良, 可, 不可）
 *   - そのグレードの範囲（min〜max の点数）
 *   - 合否（true/false）
 *   - GPA 値（優=4.0、良=3.0、可=2.0、不可=0.0）
 * ・点数を入力して該当する Enum を返すメソッド `Grade.fromScore(int score)` を実装する。
 *   - 例：90点以上=優, 70〜89=良, 60〜69=可, 〜59=不可
 *   - 範囲外の点数（負の値や100超え）は IllegalArgumentException を throw
 * ・GradeServiceのevaluateメソッドでは、`Grade` Enumを使って、期待通りの出力になるように修正する。
 * ・出力は次の形式：
 *   "点数: X → 評価: 優, 合否: pass, GPA: 4.0"
 *
 * ▼現在の出力（このまま実行した場合の例）
 * 点数: 95 → 評価: A
 * 点数: 75 → 評価: B
 * 点数: 65 → 評価: C
 * 点数: 40 → 評価: D
 * 点数: 120 → 評価: A   ←本来は例外を投げたいが、Aになってしまっている。
 *
 * ▼期待される出力（正しく実装できた場合の例）
 * 点数: 95 → 評価: 優, 合否: pass, GPA: 4.0
 * 点数: 75 → 評価: 良, 合否: pass, GPA: 3.0
 * 点数: 65 → 評価: 可, 合否: pass, GPA: 2.0
 * 点数: 40 → 評価: 不可, 合否: fail, GPA: 0.0
 * 点数: 120 → IllegalArgumentException: 点数は 0〜100 の範囲で指定してください: 120
 */
public class Main {
  public static void main(String[] args) {
    System.out.println(GradeService.evaluate(95));
    System.out.println(GradeService.evaluate(75));
    System.out.println(GradeService.evaluate(65));
    System.out.println(GradeService.evaluate(40));
    System.out.println(GradeService.evaluate(120));
  }
}
