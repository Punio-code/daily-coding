package com.example.chapter07.practice01;

/**
 * 鳥クラス。
 */
public class Bird implements Speakable {

    @Override
    public String displayName() {
        return "鳥";
    }

    @Override
    public String speak() {
        return "チュン！";
    }
}