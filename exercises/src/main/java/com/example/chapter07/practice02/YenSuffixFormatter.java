package com.example.chapter07.practice02;
import java.util.Locale;

public class YenSuffixFormatter implements PriceFormatter {

    @Override
    public String format(int yen) {
        return String.format(Locale.JAPAN, "%,d円", yen);
    }

}