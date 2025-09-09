package com.example.chapter07.practice01;

/**
 * 鳴けることを示すインターフェース
 */
public interface Speakable {

  /**
   * 鳴き声を返す。（デフォルト実装）
   *
   * @return 鳴き声
   */
  default String speak() {
    return "……";
  }

  /**
   * 表示名（日本語）を出力する。
   */
  String displayName();
}
