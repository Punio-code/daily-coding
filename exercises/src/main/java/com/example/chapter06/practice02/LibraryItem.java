package com.example.chapter06.practice02;

public abstract class LibraryItem {
    public abstract String name();

    public abstract int dailyFine();

    public int calcFine(int d) {
        return d * dailyFine();
    }
}
