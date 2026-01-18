package com.example.chapter09.practice02;

import java.util.Scanner;

/**
 * 【問題02：出席番号検索（try-with-resources への書き換え）】
 * このプログラムは、0〜4 の数値を入力として受け取り、
 * 配列 names の該当要素を表示します。
 * 入力が数値以外の場合や、範囲外インデックスの場合は特定のメッセージを表示しています。
 * 今は Scanner を try-catch-finally で明示的に close() しています。
 * 本課題では、動作・メッセージは変えずに、
 * リソース解放の書き方だけを「try-catch-finally 構文」から「try-with-resources 構文」にリファクタリングしてください。
 * <p>
 * ▼期待される出力（修正前も修正後も挙動は変わらないこと）
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
 * ▼指示（やること）
 * 1. 下記の try-catch-finally を、try-with-resources の形に書き換えること。
 * 2. 動作・出力文言・例外の捕捉順序は変更しないこと（機能差分を出さない）。
 * 3. try ブロックに含める範囲は「入力〜表示」の最小限に保つこと。
 * <p>
 * ▼ヒント
 * ・try-with-resources はブロックを抜けたタイミングで自動的に close() が呼ばれる。
 */

//try-with-resources は finally を「書かない」ための構文で、
//try の丸括弧 () の中（= resource specification）に Closeable / AutoCloseable なリソースを宣言する。
//そうすると try ブロックを抜けるときに自動で close() が呼ばれる（正常終了でも例外でも同じ）。
//したがって finally { sc.close(); } を手書きする必要がなくなる。

public class Main {
    public static void main(String[] args) {
        String[] names = {"田中", "佐藤", "鈴木", "高橋", "伊藤"};
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            int index = Integer.parseInt(line);
            String name = names[index];
            System.out.println("出席番号 " + index + " の名前は「" + name + "」です。");
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("0〜4の範囲で入力してください。");
        }
        //try-with-resources は AutoCloseable という共通インターフェースに対して close() 呼び出しを強制し、実際の解放処理はポリモーフィズムで各リソース実装に委譲される
    }
}