package com.example.chapter07.practice01;

public class Lion implements Speakable {

    @Override
    public String speak() {
        return "ガオー！";
    }

    @Override
    public String displayName() {
        return "ライオン";
    }
}
