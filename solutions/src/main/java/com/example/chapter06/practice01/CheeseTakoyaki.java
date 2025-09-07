package com.example.chapter06.practice01;

/**
 * チーズたこ焼きクラス。
 */
class CheeseTakoyaki extends Takoyaki {

  @Override
  int toppingFee() {
    return 100;
  }

  // 追加。TakoyakiクラスのdisplayNameメソッドを、CheeseTakoyakiクラスでオーバーライドする。
  @Override
  String displayName() {
    return "チーズたこ焼き";
  }
}
