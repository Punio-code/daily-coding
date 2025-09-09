package com.example.chapter07.practice02;

import java.util.Locale;

/**
 * 末尾に「円」を付けて 3桁区切りで表示するフォーマッタ
 */
public class YenSuffixFormatter implements PriceFormatter {

  @Override
  public String format(int yen) {
    return String.format(Locale.JAPAN, "%,d円", yen);
  }
}