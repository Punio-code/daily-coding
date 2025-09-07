package com.example.chapter05.practice03;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 【問題03：日付ライブラリ ― 誕生日まであと何日（LocalDate）】
 * 今日から見て、次の誕生日まで「あと何日」かを表示してください。
 * ただし、今年の誕生日が過ぎている場合は翌年の誕生日を対象とします。
 *
 * ▼現在の出力結果（このプログラムをそのまま実行した場合）
 * 今日は 2025-09-07
 * 次の誕生日は 2025-04-15
 * 誕生日まであと -145 日
 * （※今年の誕生日が過ぎていると、マイナスの日数になってしまう。）
 *
 * ▼期待される出力結果（正しく修正できた場合の例）
 * 今日は 2025-09-07
 * 次の誕生日は 2026-04-15
 * 誕生日まであと 220 日
 * （※本日が誕生日なら「0 日」と表示）
 *
 * ▼指示
 * 誕生日を生成する箇所で、今年の誕生日が過ぎていた場合の考慮が現在できていません。
 * もし今年の誕生日が過ぎていたら、翌年の日付を代入し、過ぎていなければ今年の日付を代入するようにしてください。
 * LocalDateインスタンスの生成は LocalDate.of(...) 、
 * LocalDateインスタンス同士の日付の比較は isAfter(...), isBefore(...)を使用できます。
 */
public class Main {
  public static void main(String[] args) {
    // 今日の日付
    LocalDate today = LocalDate.now();

    // 誕生日（月）
    int month = 4;

    // 誕生日（日）
    int day = 15;

    // 誕生日を作る。
    // もし今日と比べて、今年の誕生日が過ぎていたら、翌年の誕生日を代入する。過ぎていなければ今年の誕生日を代入する。
     LocalDate nextBirthday = LocalDate.of(today.getYear(), month, day); // 不具合あり

    // 今日から誕生日までの期間インスタンスを取得する。
    long days = ChronoUnit.DAYS.between(today, nextBirthday);

    System.out.println("今日は " + today);
    System.out.println("次の誕生日は " + nextBirthday);
    System.out.println("誕生日まであと " + days + " 日");
  }
}