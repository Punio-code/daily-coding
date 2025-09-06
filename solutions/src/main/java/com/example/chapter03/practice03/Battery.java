package com.example.chapter03.practice03;

/**
 * スマホのバッテリー（Battery）を表すクラス。 残量を 0〜100% の範囲で管理します。
 */
public class Battery {

  /**
   * バッテリー残量（0〜100%）
   */
  private int percentage;

  /**
   * コンストラクタ。 初期残量を指定してバッテリーを作ります。
   *
   * @param initial 初期残量（%）
   */
  public Battery(int initial) {
    // 修正：ガード処理（0〜100に丸める）
    if (initial < 0) {
      this.percentage = 0;
    } else if (initial > 100) {
      this.percentage = 100;
    } else {
      this.percentage = initial;
    }
  }

  /**
   * 充電して残量を増やします。
   *
   * @param percent 追加するパーセンテージ（0以上）
   */
  public void charge(int percent) { // 新規追加
    if (percent < 0) {
      return; // 負の値は無視
    }
    this.percentage += percent; // 加算代入する
    if (this.percentage > 100) { // 上限である100より大きくなってしまったら、100にする
      this.percentage = 100;
    }
  }

  /**
   * 表示用の文字列を返します。
   * 例：「バッテリー: 75%」
   *
   * @return 表示用の文字列
   */
  public String label() { // 新規追加
    return "バッテリー: " + this.percentage + "%";
  }
}
