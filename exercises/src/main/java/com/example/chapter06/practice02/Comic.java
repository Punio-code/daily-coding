package com.example.chapter06.practice02;

public class Comic extends LibraryItem {

    @Override
    public String name() {
        return "コミック";
    }

    @Override
    public int dailyFine() {
        return 20;
    }

    @Override
    public int calcFine(int d) {
        return Math.max(d - 1, 0) * dailyFine();
    }
}

