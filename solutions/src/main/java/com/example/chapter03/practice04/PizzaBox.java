package com.example.chapter03.practice04;

/**
 * ピザの箱（PizzaBox）を表すクラス。残りスライス数（0～8）を管理します。
 */
public class PizzaBox { // 新規作成

  /** 残りスライス数（0～8） */
  private int slices; // 新規作成

  /**
   * コンストラクタ。初期スライス数を指定します。
   * 0 未満は 0、8 超えは 8 に丸めます。
   *
   * @param initialSlices 初期スライス数
   */
  public PizzaBox(int initialSlices) { // 新規作成
    if (initialSlices < 0) {
      this.slices = 0;
    } else if (initialSlices > 8) {
      this.slices = 8;
    } else {
      this.slices = initialSlices;
    }
  }

  /**
   * 指定数のスライスを食べて減らします（0 未満にはしない）。
   *
   * @param count 減らすスライス数（0 以上）
   */
  public void eat(int count) { // 新規作成
    if (count < 0) {
      return;
    }
    this.slices -= count;
    if (this.slices < 0) {
      this.slices = 0;
    }
  }

  /**
   * 表示用の文字列を返します（例：「残り: 6切れ」）。
   *
   * @return 表示用の文字列
   */
  public String label() { // 新規作成
    return "残り: " + this.slices + "切れ";
  }
}