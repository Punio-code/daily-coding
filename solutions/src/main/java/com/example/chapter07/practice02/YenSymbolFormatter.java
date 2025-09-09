package com.example.chapter07.practice02;

import java.util.Locale;

/**
 * 先頭に「¥」を付けて 3桁区切りで表示するフォーマッタ
 */
public class YenSymbolFormatter implements PriceFormatter {

  @Override
  public String format(int yen) {
    return "¥" + String.format(Locale.JAPAN, "%,d", yen);
  }
}