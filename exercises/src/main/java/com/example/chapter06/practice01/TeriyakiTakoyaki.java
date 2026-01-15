package com.example.chapter06.practice01;


/**
 * てりやきたこ焼きクラス。
 */
class TeriyakiTakoyaki extends Takoyaki {

    @Override
    int toppingFee() {
        return 150;
    }

    @Override
    String displayName() {
        return "てりやきたこ焼き";
    }
}
