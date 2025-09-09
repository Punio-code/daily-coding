package com.example.chapter07.practice01;

import java.util.*;

/**
 * 【問題01：動物園の鳴き声案内を直そう（インターフェース／実装／ポリモーフィズム）】
 * このプログラムでは、Animalインターフェースの実装クラスのインスタンスを一つの変数 animal にまとめて
 * それぞれの鳴き声を出力するプログラムなのですが、
 * 今はどの動物も「……」としか表示されません。
 * 正しく鳴くように直し、さらに新しい動物クラス（例：Lion）を追加して出力してください。
 *
 * ▼現在の出力（このまま実行した例）
 * 犬: ……
 * 猫: ……
 * 鳥: ……
 *
 * ▼期待される出力（正しく修正できた場合の例）
 * 犬: ワン！
 * 猫: ニャー！
 * 鳥: チュン！
 * ライオン: ガオー！
 *
 * ▼指示
 * ・各動物の鳴き声が出力されるように修正してください。（実装クラスのメソッド内容を変更してよいです）
 * ・オーバーライドをしているメソッドには、 @Override をつけてください。
 * 　（@Override をつけると、オーバーライドが間違っていたときに警告が表示されることを確認してください。）
 * ・Speakableインターフェースを実装した、新しい動物クラスを定義して、animalsの中に加えて鳴き声を出力してください。
 */
public class Main {
  public static void main(String[] args) {
    // ポリモーフィズムの仕組みを使って、異なる型のインスタンスを一つの変数 animals で管理する。
    List<Speakable> animals = Arrays.asList(
        new Dog(),
        new Cat(),
        new Bird(),
        new Lion()
    );

    // 各動物の鳴き声を出力する。
    for (Speakable a : animals) {
      System.out.println(a.displayName() + ": " + a.speak());
    }
  }
}

