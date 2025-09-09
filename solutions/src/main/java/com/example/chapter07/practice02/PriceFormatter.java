package com.example.chapter07.practice02;

/**
 * 金額（円）を文字列表記に変換するフォーマッタのインターフェース
 */
public interface PriceFormatter {

  /**
   * 整数の金額（円）を、実装ごとの表記ルールで文字列にして返す。
   * 例: "1,234円" / "¥1,234" / "1,357円"（税込10%）
   *
   * @param yen 整数の金額（円）
   * @return 金額を文字列表記したものｙ
   */
  String format(int yen);
}