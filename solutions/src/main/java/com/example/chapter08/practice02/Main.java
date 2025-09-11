package com.example.chapter08.practice02;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 【問題02：学食メニュー価格管理（Mapの基本操作ぜんぶ練習）】
 * このプログラムでは、学食の「メニュー名 → 価格（税抜）」を Map で管理します。
 * 次の流れで操作し、Map のよく使うメソッドを一通り練習することが目的です（全6ステップ）。
 * (1)初期メニューを登録する。
 * (2)初期メニューの一覧を出力する。
 * (3)既存メニューの価格を更新し、新メニューを追加する。
 * (4)未登録メニューの価格取得では既定値を使って表示する。
 * (5)すべての価格を税込10%に一括変換したあと、合計金額を表示する。
 * (6)最後にメニューを全消去する。
 *
 * しかし、今のコードには不具合・未実装が含まれており、期待される出力がされていません。
 * 下の「▼指示」に従って修正し、期待される出力結果になるようにしてください。
 *
 * ▼現在の出力（このまま実行した場合）
 * メニュー（税抜・初期）: 5件
 * ---- 追加／更新（税抜） ----
 * メニュー（税抜・追加/更新後）: 5件
 * 味噌汁の価格（未登録時は0円で表示）: null円
 * ---- 税込（10%）へ一括変換 ----
 * メニュー（税込）: 5件
 * 税込合計: 1550円
 * ---- 片付け（全消去） ----
 * メニュー件数: 5件
 *
 * ▼期待される出力（正しく修正できた場合の例）
 * メニュー（税抜・初期）: 5件
 *  - カレー: 350円
 *  - ラーメン: 420円
 *  - うどん: 305円
 *  - サラダ: 155円
 *  - パン: 180円
 * ---- 追加／更新（税抜） ----
 * メニュー（税抜・追加/更新後）: 6件
 *  - カレー: 360円
 *  - ラーメン: 420円
 *  - うどん: 305円
 *  - サラダ: 155円
 *  - パン: 180円
 *  - からあげ丼: 500円
 * 味噌汁の価格（未登録時は0円で表示）: 0円
 * ---- 税込（10%）へ一括変換 ----
 * メニュー（税込）: 6件
 *  - カレー: 396円
 *  - ラーメン: 462円
 *  - うどん: 336円
 *  - サラダ: 171円
 *  - パン: 198円
 *  - からあげ丼: 550円
 * 税込合計: 2113円
 * ---- 片付け（全消去） ----
 * メニュー件数: 0件
 *
 * ▼指示
 * ・期待する出力結果になるように、実装を修正してください。
 *
 * ▼ヒント
 * ・(2) 一覧出力が不足している。
 *       entrySet() を for-each で回し、キーと値を「 - 名: 金額円」で表示。
 *       使用候補：map.entrySet(), Map.Entry#getKey, Map.Entry#getValue
 * ・(3) 更新/追加が不足している。
 *       既存判定に containsKey(name)、
 *       既存の更新は replace(name, price) または put(name, price)、
 *       新規追加は put(name, price) を使う。
 * ・(4) 未登録メニューの取得で null 表示になる。
 *       getOrDefault("味噌汁", 0) を使って 0 を既定値にする。
 * ・(5) 税込変換が切り捨てになっている。
 *       replaceAll((k,v) -> (int)Math.round(v * 1.1)) で一括変換。
 *       合計は values() を取り出して合算。
 * ・(6) 全消去が未実装。
 *       clear() を呼び出して要素をすべて削除する。
 *
 * ▼ねらい（学習項目）
 * ・Map の基本操作を一通り体験：put / get / containsKey / getOrDefault / replace / replaceAll / values / entrySet / size / clear
 * ・「更新」と「新規追加」を使い分けることができる。
 */
public class Main {
  public static void main(String[] args) {
    // 追加順で出力したいので LinkedHashMap を使用（Map の実装は自由に差し替え可）
    Map<String, Integer> menu = new LinkedHashMap<>();

    // (1)初期メニューを登録する。
    addInitialMenu(menu);

    // (2)初期メニューの一覧を出力する。
    printMenu("メニュー（税抜・初期）", menu);

    // (3)既存メニューの価格を更新し、新メニューを追加する。
    // カレーを360円に更新し、からあげ丼を500円で新規追加する。
    addOrUpdate(menu, "カレー", 360);
    addOrUpdate(menu, "からあげ丼", 500);

    System.out.println("---- 追加／更新（税抜） ----");
    printMenu("メニュー（税抜・追加/更新後）", menu);

    // (4)未登録メニューの価格取得では既定値を使って表示する。
    // 本来は未登録の「味噌汁」を 0円 で表示したい
    System.out.println("味噌汁の価格（未登録時は0円で表示）: "
        + menu.getOrDefault("味噌汁", 0) + "円"); // 修正。「未登録時は0円」という仕様のため、null を出力していた get を getOrDefault に修正。

    // (5)すべての価格を税込10%に一括変換したあと、合計金額を表示する。
    System.out.println("---- 税込（10%）へ一括変換 ----");
    toTaxIncluded(menu);
    printMenu("メニュー（税込）", menu);
    System.out.println("税込合計: " + sum(menu) + "円");

    // (6)最後にメニューを全消去する。
    System.out.println("---- 片付け（全消去） ----");
    clearAllMenu(menu);
    System.out.println("メニュー件数: " + menu.size() + "件");
  }

  /**
   * 初期メニュー（税抜）を登録する。
   *
   * @param menu キー：メニュー名, 値：価格（税抜）のマップ
   */
  private static void addInitialMenu(Map<String, Integer> menu) {
    menu.put("カレー", 350);
    menu.put("ラーメン", 420);
    menu.put("うどん", 305);
    menu.put("サラダ", 155);
    menu.put("パン", 180);
  }

  /**
   * メニューの件数と、各メニューのメニュー名・価格を表示する。
   *
   * @param title 見出しタイトル（例：「メニュー（税抜・初期）」）
   * @param menu キー：メニュー名, 値：価格のマップ
   */
  private static void printMenu(String title, Map<String, Integer> menu) {
    System.out.println(title + ": " + menu.size() + "件");
    for (Map.Entry<String, Integer> e : menu.entrySet()) { // 追加。entrySetで、マップ内を走査。
      System.out.println(" - " + e.getKey() + ": " + e.getValue() + "円"); // 追加。出力形式「 - 名: 金額円」に従って1件ずつ表示。
    }
  }

  /**
   * 既存メニューは価格を更新し、未登録メニューは新規追加する。
   *
   * @param menu キー：メニュー名, 値：価格のマップ
   * @param name メニュー名
   * @param price 価格（税抜）
   */
  private static void addOrUpdate(Map<String, Integer> menu, String name, int price) {
    if (menu.containsKey(name)) {
      menu.replace(name, price); // 修正。「既存は更新」という仕様のため、 replace で実装。
    } else {
      menu.put(name, price); // 修正。「未登録は追加」という仕様のため、 put で実装。。
    }
  }

  /**
   * 価格を税込10%に一括変換する（四捨五入で整数化し、全要素を更新する）。
   *
   * @param menu キー：メニュー名, 値：価格のマップ
   */
  private static void toTaxIncluded(Map<String, Integer> menu) {
    // 修正。税込10%の価格に四捨五入で一括更新する仕様のため、切り捨て計算＋個別 put を replaceAll＋round に修正。
    menu.replaceAll((k, v) -> (int) Math.round(v * 1.1));

  }

  /**
   * 合計金額（values の合計）を計算して返す。
   *
   * @param menu キー：メニュー名, 値：価格のマップ
   * @return 合計金額
   */
  private static int sum(Map<String, Integer> menu) {
    int total = 0;
    for (int p : menu.values()) {
      total += p;
    }
    return total;
  }

  /**
   * マップ内の要素をすべて削除する。
   *
   * @param menu キー：メニュー名, 値：価格のマップ
   */
  private static void clearAllMenu(Map<String, Integer> menu) {
    menu.clear(); // 修正。「要素をすべて削除する」という仕様のため、 clear 呼び出しで実装。
  }
}