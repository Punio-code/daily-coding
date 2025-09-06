package com.example.chapter03.practice02;

/**
 * 信号機（TrafficLight）を表すクラス。現在の色を管理して切り替えます。
 */
public class TrafficLight {

  /**
   * 現在の色（"赤" / "黄" / "青"）
   */
  private String color; // 修正：public → private（カプセル化）

  /**
   * 初期色を指定して信号機を作ります。
   *
   * @param initialColor 初期色（"赤" / "黄" / "青"）
   */
  public TrafficLight(String initialColor) {
    this.color = initialColor; // 修正：渡された初期色をそのまま設定
  }

  /**
   * 次の色へ切り替えます（赤→青→黄→赤）。
   */
  public void next() {
    // 修正：色を順番に切り替える
    if ("赤".equals(this.color)) {
      this.color = "青";
    } else if ("青".equals(this.color)) {
      this.color = "黄";
    } else {
      // "黄" もしくは想定外の文字列は赤へ
      this.color = "赤";
    }
  }

  /**
   * 表示用の文字列（例: "信号: 青"）を返します。
   *
   * @return 表示用の文字列
   */
  public String label() {
    return "信号: " + this.color; // 修正：色名を含めて返す
  }
}