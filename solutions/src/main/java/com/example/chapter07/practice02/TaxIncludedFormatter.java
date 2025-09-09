package com.example.chapter07.practice02;

import java.util.Locale;

/**
 * 税込10%（四捨五入）で計算し、末尾に「円」を付けて表示するフォーマッタ
 */
public class TaxIncludedFormatter implements PriceFormatter {

  @Override
  public String format(int yen) {
    int taxed = (int) Math.round(yen * 1.1); // 金額に消費税10%分を加えた合計金額を算出する。
    return String.format(Locale.JAPAN, "%,d円", taxed);
  }
}