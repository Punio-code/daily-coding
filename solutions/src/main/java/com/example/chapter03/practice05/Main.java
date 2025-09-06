package com.example.chapter03.practice05;

/**
 * 【問題05：テレビを正しく操作しよう（クラスを1から作成／コンストラクタでガード＋自作メソッド）】
 *
 * このプログラムは、テレビ（Televisionクラス）の
 * ・チャンネル（1〜12）
 * ・音量（0〜100%）
 * ・ミュートON/OFF
 * をプログラムから操作し、現在の状態を表示するプログラムです。
 * Television クラスは存在しないため、あなたが 1 から作ってください。
 *
 * ▼使い方（この Main が行うこと）
 * 1) 初期チャンネルと初期音量を指定して Television を new する（範囲外の値はコンストラクタでガードする）。
 * 2) setChannel(番号) でチャンネル変更、setVolume(増減値) で音量を上下、
 *    mute()/unmute() でミュートON/OFFを切り替える。
 * 3) label() で「チャンネル: X / 音量: Y% / ミュート: ON|OFF」の形式で表示する。
 *
 * ▼現在の状態（このプログラムをそのまま実行した場合）
 * コンパイルエラー（Television クラスが存在しないため）
 *
 * ▼期待される出力結果
 * チャンネル: 7 / 音量: 100% / ミュート: OFF
 * チャンネル: 5 / 音量: 0% / ミュート: ON
 *
 * ▼指示（以下のクラスを作成してください）
 * ・クラスを配置するパッケージ：この Main が配置されているパッケージと同じパッケージ
 * ・クラス名：public class Television
 *
 * ・フィールド（すべて private）
 *   - int channel;   // 現在のチャンネル（1〜12）
 *   - int volume;    // 現在の音量（0〜100）※単位は％
 *   - boolean muted; // ミュート中なら true、そうでなければ false（デフォルト値は false とする）
 *
 * ・コンストラクタ
 *   - public Television(int initialChannel, int initialVolume)
 *   - ▼以下のガード処理を実装する
 *     　　チャンネル：
 *     　　    1 未満の場合 → 1をセットする
 *     　　    12 超えの場合 → 12をセットする
 *     　　    それ以外の場合 → そのままの値をセットする
 *     　　音量：
 *     　　   0 未満の場合 → 0をセットする
 *     　　   100 超えの場合 → 100をセットする
 *     　　   それ以外の場合 → そのままの値をセットする
 *     　　ミュート状態は false で開始する
 *
 * ・メソッド（あなたが 1 から作る）
 *   - public void setChannel(int number)
 *       仕様：number が 1〜12 のときだけ channel を更新。範囲外は何もしない。
 *
 *   - public void setVolume(int delta)
 *       仕様：volume に delta を加算し、結果を 0〜100 に収める（0 未満は 0、100 超えは 100）。
 *
 *   - public void mute()
 *       仕様：muted を true にする。
 *
 *   - public void unmute()
 *       仕様：muted を false にする。
 *
 *   - public String label()
 *       仕様：「チャンネル: X / 音量: Y% / ミュート: ON|OFF」を返す。
 *            （muted が true なら ON、false なら OFF と表示）
 *       例：「チャンネル: 5 / 音量: 40% / ミュート: OFF」
 */
class Main {
  public static void main(String[] args) {
    // ケース1：初期チャンネル 0（→1 に丸め）、音量 95（そのまま）
    Television tv1 = new Television(0, 95);
    tv1.setChannel(7);       // 7 に変更
    tv1.setVolume(10);    // 95 + 10 = 105 → 100 に丸め
    tv1.mute();              // ミュートON
    tv1.unmute();            // ミュートOFF
    System.out.println(tv1.label()); // 期待：チャンネル: 7 / 音量: 100% / ミュート: OFF

    // ケース2：初期チャンネル 13（→12 に丸め）、音量 -5（→0 に丸め）
    Television tv2 = new Television(13, -5);
    tv2.setChannel(5);       // 5 に変更
    tv2.setVolume(-10);   // 0 + (-10) = -10 → 0 に丸め
    tv2.mute();              // ミュートON
    System.out.println(tv2.label()); // 期待：チャンネル: 5 / 音量: 0% / ミュート: ON
  }
}