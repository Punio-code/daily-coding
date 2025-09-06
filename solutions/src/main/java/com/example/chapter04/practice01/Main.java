package com.example.chapter04.practice01;

/**
 * 【問題01：カレンダー予定の不具合を直そう（オーバーロード, クラスフィールド, クラスメソッド）】
 *
 * これは、カレンダー予定（Event）を作成し、所要時間を加算して、
 * 最後に「予定: タイトル, 所要時間: ○分, 場所: △△」を表示するプログラムです。
 * 現在のコードには不具合があり、期待どおりの表示になりません。
 *
 * ▼現在の出力結果（このプログラムをそのまま実行した場合）
 * 予定
 * 0
 *
 * ▼期待される出力結果
 * 予定: no title, 所要時間: 45分, 場所: オンライン
 * 予定: 朝会, 所要時間: 45分, 場所: オンライン
 * 予定: 1on1, 所要時間: 35分, 場所: オンライン
 * 予定: 開発相談会, 所要時間: 60分, 場所: 会議室A
 * 4
 *
 * ▼指示
 * ・Eventのフィールド title / minutes / location の修飾子を private にしてください。
 * ・Eventクラスで、引数を3つ持つコンストラクタが未実装なので、実装してください（コンストラクタのオーバーロード）
 *   - Event(String title, int minutes) 　　　　　　　　　　   → 引数で「タイトル」と「所要時間」を指定可能。「場所」はデフォルト値。
 *   - Event(String title, int minutes, String location)   → 引数で「タイトル」と「所要時間」と「場所」を指定可能。
 * ・Eventクラスの　addMinutesメソッド　が未実装なので、実装してください（メソッドのオーバーロード）
 *   - void addMinutes()     　　　　 : 所要時間を +15 分 する。
 *   - void addMinutes(int minutes) : 所要時間を +n 分 する。
 * ・Eventクラスの labelメソッド に不具合があるため修正してください。
 * ・作成された予定総数（Eventインスタンスの数）を、Event.getTotalEvents() で取得できるようにしてください。（クラスメソッド、クラスフィールド）
 * ・Mainクラス の mainメソッドのコメントに従って、予定を合計 4 件作成し、addMinutesメソッド で加算後に labelメソッド を使用して結果を表示してください。
 */
class Main {
  public static void main(String[] args) {
    // 1件目: 全てデフォルト（予定: no title, 所要時間: 30分, 場所: オンライン）で予定を作成する。
    Event e1 = new Event();

    // 1件目: 所要時間を15分加算後、結果を表示する。
    // 1件目の期待出力結果: 予定: no title, 所要時間: 45分, 場所: オンライン
    e1.addMinutes();
    System.out.println(e1.label());

    // 以下にあなた自身でコードを追加してください。
    // 2件目: タイトル: 朝会 で予定を作成する。
    Event e2 = new Event("朝会"); // 追加

    // 2件目: 所要時間を15分加算後、結果を表示する。
    // 2件目の期待出力結果: 予定: 朝会, 所要時間: 45分, 場所: オンライン
    e2.addMinutes(); // 追加
    System.out.println(e2.label()); // 追加

    // 3件目: タイトル: 1on1, 所要時間: 20分 で予定を作成する。
    Event e3 = new Event("1on1", 20); // 追加

    // 3件目: 所要時間を15分加算後、結果を表示する。
    // 3件目の期待出力結果: 予定: 1on1, 所要時間: 35分, 場所: オンライン
    e3.addMinutes(); // 追加
    System.out.println(e3.label()); // 追加

    // 4件目：タイトル: 開発相談会, 所要時間: 25分, 場所: 会議室A で予定を作成する。
    Event e4 = new Event("開発相談会", 25, "会議室A"); // 追加

    // 4件目: 所要時間を35分加算後、結果を表示する。
    // 4件目の期待出力結果: 予定: 開発相談会, 所要時間: 60分, 場所: 会議室A
    e4.addMinutes(35); // 追加
    System.out.println(e4.label()); // 追加

    // 予定の総数を表示（期待: 4）
    System.out.println(Event.getTotalEvents());
  }
}
