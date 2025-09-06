package com.example.chapter03.practice05;

/**
 * テレビ（Television）を表すクラス。
 * チャンネルは 1〜12、音量は 0〜100%、ミュートON/OFFを扱います。
 */
public class Television { // 新規作成

  /**
   * 現在のチャンネル（1〜12）
   */
  private int channel; // 新規作成

  /**
   * 現在の音量（0〜100）
   */
  private int volume; // 新規作成

  /**
   * ミュート中なら true
   */
  private boolean muted; // 新規作成

  /**
   * 初期チャンネルと初期音量を指定してテレビを作ります（ガード付き）。
   *
   * @param initialChannel 初期チャンネル
   * @param initialVolume  初期音量（%）
   */
  public Television(int initialChannel, int initialVolume) { // 新規作成
    if (initialChannel < 1) {
      this.channel = 1;
    } else if (initialChannel > 12) {
      this.channel = 12;
    } else {
      this.channel = initialChannel;
    }

    if (initialVolume < 0) {
      this.volume = 0;
    } else if (initialVolume > 100) {
      this.volume = 100;
    } else {
      this.volume = initialVolume;
    }

    this.muted = false;
  }

  /**
   * チャンネルを変更します（1〜12 のときだけ有効）。
   *
   * @param number 設定するチャンネル番号
   */
  public void setChannel(int number) { // 新規作成
    if (number >= 1 && number <= 12) {
      this.channel = number;
    }
  }

  /**
   * 音量を増減します（結果を 0〜100 に丸めます）。
   *
   * @param delta 増減値（正で上げる／負で下げる）
   */
  public void setVolume(int delta) { // 新規作成
    this.volume = this.volume + delta;
    if (this.volume < 0) {
      this.volume = 0;
    }
    if (this.volume > 100) {
      this.volume = 100;
    }
  }

  /** ミュートをONにします。 */
  public void mute() { // 新規作成
    this.muted = true;
  }

  /** ミュートをOFFにします。 */
  public void unmute() { // 新規作成
    this.muted = false;
  }

  /**
   * 現在の状態を文字列で返します。
   *
   * @return 例：「チャンネル: 7 / 音量: 100% / ミュート: OFF」
   */
  public String label() { // 新規作成
    String muteLabel = this.muted ? "ON" : "OFF";
    return "チャンネル: " + this.channel + " / 音量: " + this.volume + "% / ミュート: " + muteLabel;
  }
}