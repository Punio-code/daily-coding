package com.example.chapter07.practice01;

/**
 * 猫クラス。
 */
public class Cat implements Speakable {

  public String speak(String suffix) {
    return "ニャー" + suffix;
  }

  @Override
  public String displayName() {
    return "猫";
  }
}