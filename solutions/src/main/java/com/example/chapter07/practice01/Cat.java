package com.example.chapter07.practice01;

/**
 * 猫クラス。
 */
public class Cat implements Speakable {

  @Override
  public String speak() {
    return "ニャー！";
  }

  @Override
  public String displayName() {
    return "猫";
  }
}