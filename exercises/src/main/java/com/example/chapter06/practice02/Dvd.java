package com.example.chapter06.practice02;

public class Dvd extends LibraryItem {

    @Override
    public String name() {
        return "DVD";
    }

    @Override
    public int dailyFine() {
        return 100;
    }

    @Override
    public int calcFine(int d) {
        return Math.min(d * dailyFine(), 500);
    }
}
