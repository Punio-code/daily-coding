package com.example.chapter06.practice01;

/**
 * 【問題01：たこ焼き屋さんの表示名を直そう（継承 / オーバーライド / 抽象クラス）】
 * たこ焼きの基本料金は 400 円です。各トッピングで「追加料金」と「表示名（name）」が異なります。
 * 現在のプログラムでは、出力が「たこやき: 500円」になってしまう不具合があります。これを修正してください。
 * また、Takoyakiクラスを継承したオリジナルのたこ焼きクラスを作って、mainメソッドで他と同様に出力してください。
 *
 * ▼現在の出力（このまま実行した例）
 * たこ焼き: 500円
 * ねぎたこ焼き: 480円
 *
 * ▼期待される出力（正しく修正できた場合の例）
 * チーズたこ焼き: 500円
 * ねぎたこ焼き: 480円
 * てりやきたこ焼き: 550円
 * （※3つ目は自分で作成したクラスの表示名と合計料金が表示されること）
 *
 * ▼指示
 *  (1) CheeseTakoyaki において、"チーズたこ焼き" を表示できるようにする。
 *  (2) Takoyakiクラスを継承した新しいたこ焼きクラス（例: TeriyakiTakoyaki, +150円）を作り、
 *      表示名も正しくオーバーライドして、Main で金額を表示してみる。
 *
 * ▼ヒント
 *  - オーバーライドの条件は「メソッド名・引数・戻り値の型が完全一致」です。
 */
public class Main {
    public static void main(String[] args) {
      CheeseTakoyaki cheese = new CheeseTakoyaki();
      NegiTakoyaki negi = new NegiTakoyaki();

      // 不具合：現在は「チーズたこ焼き」が「たこやき」と表示される
      System.out.println(cheese.displayName() + ": " + cheese.total() + "円");
      System.out.println(negi.displayName() + ": " + negi.total() + "円");
    }
}
