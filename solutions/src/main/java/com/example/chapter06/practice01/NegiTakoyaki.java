package com.example.chapter06.practice01;

/**
 * ねぎたこ焼きクラス。
 */
class NegiTakoyaki extends Takoyaki {

  @Override
  int toppingFee() {
    return 80;
  }

  @Override
  String displayName() {
    return "ねぎたこ焼き";
  }
}
