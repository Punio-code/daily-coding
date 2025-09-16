package com.example.chapter09.practice04;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 【問題04：日付文字列をパースしよう（throws でチェック例外を伝える）】
 * これは、"yyyy/MM/dd" 形式の日付文字列を LocalDate 型に変換するプログラムです。
 * 変換には SimpleDateFormat#parse を利用します。
 *
 * ▼現在の問題点
 * ・parse メソッドが ParseException（＝チェック例外）をスローするのに、
 *  例外処理をしておらず、コンパイルエラーになります。
 *
 * ▼やること
 * ・parseDate メソッドに throws 句を追加してコンパイルエラーを解消してください。
 * ・呼び出し元（main メソッド）では try-catch を使い、
 *   ParseException を捕捉して「日付の形式が不正です」と表示してください。
 *
 * ▼現在の出力（このまま実行した場合）
 * コンパイルエラーになる。
 *
 * ▼期待される出力（正しく実装した場合の例）
 * 【ケース1：正常入力（2025/09/16）】
 * 2025-09-16
 *
 * 【ケース2：形式不正（2025-09-16）】
 * 日付の形式が不正です
 */
public class Main {
  public static void main(String[] args) {
    Date d1 = parseDate("2025/09/16"); // 期待するフォーマットであるため、変換に成功する。
    System.out.println(d1);

    Date d2 = parseDate("2025-09-16"); // ハイフン区切りのため（つまり、期待するフォーマットではないため）、例外発生。
    System.out.println(d2);
  }

  /**
   * "yyyy/MM/dd" 形式の日付文字列を LocalDate型に変換する。
   *
   * @param text 日付文字列
   * @return 変換後のLocalDate型のインスタンス
   */
  public static LocalDate parseDate(String text) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date parsed = sdf.parse(text); // ← ParseException が発生する可能性あり（今は throws していないのでコンパイルエラー）
    return parsed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
}