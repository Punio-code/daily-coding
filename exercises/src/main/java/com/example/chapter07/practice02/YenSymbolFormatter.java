package com.example.chapter07.practice02;

import java.util.Locale;

public class YenSymbolFormatter implements PriceFormatter {
    @Override
    public String format(int yen) {
        return "\uFFE5" + String.format(Locale.JAPAN, "%,d", yen);
    }
}
