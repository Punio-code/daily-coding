package com.example.chapter03.practice02;

/**
 * 信号機（TrafficLight）を表すクラス。現在の色を管理して切り替えます。
 */
public class TrafficLight {

  /**
   * 現在の色（"赤" / "黄" / "青"）
   */
  public String color;

  /**
   * 初期色を指定して信号機を作ります。
   *
   * @param initialColor 初期色（"赤" / "黄" / "青"）
   */
  public TrafficLight(String initialColor) {
    this.color = "赤";
  }

  /**
   * 次の色へ切り替えます（赤→青→黄→赤）。
   */
  public void next() {
    // 実装する。
  }

  /**
   * 表示用の文字列（例: "信号: 青"）を返します。
   *
   * @return 表示用の文字列
   */
  public String label() {
    return "信号"; // ← 不具合：色が出ていない（直す）
  }
}