package com.example.chapter07.practice01;

/**
 * 鳥クラス。
 */
public class Bird implements Speakable {

  public String sound(String suffix) {
    return "チュン！" + suffix;
  }

  @Override
  public String displayName() {
    return "鳥";
  }
}
