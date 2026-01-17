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
 * <p>
 * しかし、今のコードには不具合・未実装が含まれており、期待される出力がされていません。
 * 下の「▼指示」に従って修正し、期待される出力結果になるようにしてください。
 * <p>
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
 * <p>
 * ▼期待される出力（正しく修正できた場合の例）
 * メニュー（税抜・初期）: 5件
 * - カレー: 350円
 * - ラーメン: 420円
 * - うどん: 305円
 * - サラダ: 155円
 * - パン: 180円
 * ---- 追加／更新（税抜） ----
 * メニュー（税抜・追加/更新後）: 6件
 * - カレー: 360円
 * - ラーメン: 420円
 * - うどん: 305円
 * - サラダ: 155円
 * - パン: 180円
 * - からあげ丼: 500円
 * 味噌汁の価格（未登録時は0円で表示）: 0円
 * ---- 税込（10%）へ一括変換 ----
 * メニュー（税込）: 6件
 * - カレー: 396円
 * - ラーメン: 462円
 * - うどん: 336円
 * - サラダ: 171円
 * - パン: 198円
 * - からあげ丼: 550円
 * 税込合計: 2113円
 * ---- 片付け（全消去） ----
 * メニュー件数: 0件
 * <p>
 * ▼指示
 * ・期待する出力結果になるように、実装を修正してください。
 * <p>
 * ▼ヒント
 * ・(2) 一覧出力が不足している。
 * entrySet() を for-each で回し、キーと値を「 - 名: 金額円」で表示。
 * 使用候補：map.entrySet(), Map.Entry#getKey, Map.Entry#getValue
 * ・(3) 更新/追加が不足している。
 * 既存判定に containsKey(name)、
 * 既存の更新は replace(name, price) または put(name, price)、
 * 新規追加は put(name, price) を使う。
 * ・(4) 未登録メニューの取得で null 表示になる。
 * getOrDefault("味噌汁", 0) を使って 0 を既定値にする。
 * ・(5) 税込変換が切り捨てになっている。
 * replaceAll((k,v) -> (int)Math.round(v * 1.1)) で一括変換。
 * 合計は values() を取り出して合算。
 * ・(6) 全消去が未実装。
 * clear() を呼び出して要素をすべて削除する。
 * <p>
 * ▼ねらい（学習項目）
 * ・Map の基本操作を一通り体験：put / get / containsKey / getOrDefault / replace / replaceAll / values / entrySet / size / clear
 * ・「更新」と「新規追加」を使い分けることができる。
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> menu = new LinkedHashMap<>();

        addInitialMenu(menu);
        printMenu("メニュー（税抜・初期）", menu);

        addOrUpdate(menu, "カレー", 360);
        addOrUpdate(menu, "からあげ丼", 500);

        System.out.println("---- 追加／更新（税抜） ----");
        printMenu("メニュー（税抜・追加/更新後）", menu);

        // (4) 指示通り getOrDefault を使用。null を防ぎ、存在しない場合は 0 を返します。
        System.out.println("味噌汁の価格（未登録時は0円で表示）: " + menu.getOrDefault("味噌汁", 0) + "円");

        System.out.println("---- 税込（10%）へ一括変換 ----");
        toTaxIncluded(menu);
        printMenu("メニュー（税込）", menu);
        System.out.println("税込合計: " + sum(menu) + "円");

        System.out.println("---- 片付け（全消去） ----");
        clearAllMenu(menu);
        System.out.println("メニュー件数: " + menu.size() + "件");
    }

    private static void addInitialMenu(Map<String, Integer> menu) {
        menu.put("カレー", 350);
        menu.put("ラーメン", 420);
        menu.put("うどん", 305);
        menu.put("サラダ", 155);
        menu.put("パン", 180);
    }

    /**
     * (2) 一覧出力の実装
     * entrySet() を使うことで、キーと値を一度に取得し、Mapを再検索する手間を省きます。
     */
    private static void printMenu(String title, Map<String, Integer> menu) {
        System.out.println(title + ": " + menu.size() + "件");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + "円");
        }
    }

    /**
     * (3) 更新/追加の実装
     */
    private static void addOrUpdate(Map<String, Integer> menu, String name, int price) {
        if (menu.containsKey(name)) {
            menu.replace(name, price); // 既存なら置換
        } else {
            menu.put(name, price);     // 新規なら追加
        }
    }

    /**
     * (5) 税込変換の一括処理
     * replaceAll を使うことで、全ての値をラムダ式で一括変換できます。
     */
    private static void toTaxIncluded(Map<String, Integer> menu) {
        // 四捨五入を実現するために Math.round を使用。引数は double にキャストします。
        menu.replaceAll((k, v) -> (int) Math.round(v * 1.1));
    }

    private static int sum(Map<String, Integer> menu) {
        int total = 0;
        for (int p : menu.values()) {
            total += p;
        }
        return total;
    }

    /**
     * (6) 全消去
     */
    private static void clearAllMenu(Map<String, Integer> menu) {
        menu.clear();
    }
}