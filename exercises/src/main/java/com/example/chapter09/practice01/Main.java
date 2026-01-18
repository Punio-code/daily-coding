package com.example.chapter09.practice01;

import java.util.Scanner;

/**
 * 【問題01：出席番号検索（try-catchで入力エラーを出し分けよう）】
 * このプログラムは、0〜4 の数値を入力として受け取り、
 * 配列 names の該当要素を表示します。
 * ただし現在は例外処理が無く、数字以外や 0〜4 以外の数値で実行時例外が発生して終了します。
 * <p>
 * ▼現在の出力（このまま実行した場合の例）
 * 入力内容: 5
 * 出力内容:
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
 * at com.example.chapter09.practice01.Main.main(Main.java:50)
 * <p>
 * ▼期待される出力（正しく実装できた場合の例）
 * 【ケース1：正常（0〜4 の整数）】
 * 入力内容: 3
 * 出力内容: 出席番号 3 の名前は「高橋」です。
 * <p>
 * 【ケース2：数字だけど 0〜4 以外（例：5, -1 など）】
 * 入力内容: 5
 * 出力内容: 0〜4の範囲で入力してください。
 * <p>
 * 【ケース3：数字以外（例：abc）】
 * 入力内容: abc
 * 出力内容: 数字を入力してください。
 * <p>
 * ▼指示
 * ・以下の仕様を満たすように try-catch で例外処理を実装してください。
 * - 数字以外のとき：NumberFormatException を捕捉し「数字を入力してください。」と表示する。
 * - 数字だが 0〜4 以外のとき：ArrayIndexOutOfBoundsException を捕捉し「0〜4の範囲で入力してください。」と表示する。
 * ・正常時は「出席番号 {n} の名前は「{名前}」です。」と表示する。
 * ・Scanner は最後にfinallyで close する。
 * <p>
 * ▼ヒント
 * ・Integer.parseInt(line) は、数字以外だと NumberFormatException を投げます。
 * ・names[index] は、インデックスが範囲外だと ArrayIndexOutOfBoundsException を投げます。
 * ・tryブロックは、必要最小限の範囲を囲むようにすると、読みやすいコードになります。
 */
public class Main {
    public static void main(String[] args) {
        String[] names = {"田中", "佐藤", "鈴木", "高橋", "伊藤"};
        System.out.println("input Number");

        Scanner sc = new Scanner(System.in);

        try {
            String line = sc.nextLine();
            int index = Integer.parseInt(line); // ← line が数字以外の場合、 NumberFormatException が投げられる。
            String name = names[index];         // ← 0〜4 以外の場合、 ArrayIndexOutOfBoundsException が投げられる。
            System.out.println("出席番号 " + index + " の名前は「" + name + "」です。");
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("0〜4の範囲で入力してください。");
        } finally {
            sc.close();
        }

    }
}