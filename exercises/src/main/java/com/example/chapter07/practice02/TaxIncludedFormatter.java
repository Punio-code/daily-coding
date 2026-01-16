package com.example.chapter07.practice02;

import java.util.Locale;

public class TaxIncludedFormatter implements PriceFormatter {

    @Override
    public String format(int yen) {
        int denominator = 100;
        int numerator = denominator / 2;
        int taxed = (yen * 110 + numerator) / denominator;
        return String.format(Locale.JAPAN, "%,d円", taxed);
    }
}