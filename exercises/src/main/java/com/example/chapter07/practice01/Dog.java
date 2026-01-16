package com.example.chapter07.practice01;

/**
 * 犬クラス。
 */
public class Dog implements Speakable {

    @Override
    public String speak() {
        return "ワン！";
    }

    @Override
    public String displayName() {
        return "犬";
    }
}