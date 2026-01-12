package com.example.chapter03.practice05;

public class Television {

    /**
     * ・フィールド（すべて private）
     * - int channel;   // 現在のチャンネル（1〜12）
     * - int volume;    // 現在の音量（0〜100）※単位は％
     * - boolean muted; // ミュート中なら true、そうでなければ false（デフォルト値は false とする）
     */

    private boolean muted;
    private int channel;
    private int volume;

    /**
     * コンストラクタ。
     * 指定された枚数でピザを用意します。範囲外の場合はガード処理を行います。
     *
     * @param initialChannel 最初のﾁｬﾝﾈﾙ
     *                       ▼以下のガード処理を実装する
     *                       チャンネル：
     *                       1 未満の場合 → 1をセットする
     *                       12 超えの場合 → 12をセットする
     *                       それ以外の場合 → そのままの値をセットする
     * @param initialVolume  最初のボリューム
     *                       0 未満の場合 → 0をセットする
     *                       100 超えの場合 → 100をセットする
     *                       それ以外の場合 → そのままの値をセットする
     *                       ミュート状態は false で開始する
     */
    public Television(int initialChannel, int initialVolume) {
        setChannel(initialChannel);
        setVolume(initialVolume);
    }
    /*
      コンストラクタ 終わり
     */

    //setter
    public void setChannel(int value) {
        if (value < 1) {
            this.channel = 1;
        } else if (value > 12) {
            this.channel = 12;
        } else {
            this.channel = value;
        }
    }

    public void setVolume(int delta) {
        int nextVolume = this.volume + delta;
        if (nextVolume > 100) {
            nextVolume = 100;
        } else if (nextVolume < 0) {
            nextVolume = 0;
        }
        this.volume = nextVolume;
    }
    //setter ここまで

    public void mute() {
        this.muted = true;
    }

    public void unmute() {
        this.muted = false;
    }

    public String label() {
        return "チャンネル: " + this.channel + "音量: " + this.volume + "%" + "ミュート: " + (this.muted ? "オン" : "オフ");
    }
}
