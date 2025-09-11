package com.example.chapter08.practice01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 【問題01：朝読書の本リストを整理しよう（Listの基本操作）】
 * このプログラムでは、List を使った本リストの基本操作（add / get / sort / remove / size）を練習します。
 * 具体的には以下の順番で処理をしています。
 * (1)リストに要素（本のタイトル）を追加。
 * (2)リストの中身を表示。
 * (3)リスト内の要素で「【読了】」が含まれているものをリストから削除。
 * (4)リスト内の要素を辞書順の降順に並び替える。
 * (5)リストの中身を表示。
 *
 * しかし、未実装の箇所やロジック上の不具合があり、期待通りに出力されていません。
 * 下の「▼指示」に従ってコードを修正し、期待される出力になるように完成させてください。
 *
 * ▼現在の出力（このまま実行した場合）
 * 本（初期）: 5件
 *  - [1] 国語の物語
 *  - [2] 科学まんが【読了】
 *  - [3] 歴史入門【読了】
 *  - [4] 宇宙のふしぎ
 *  - [5] 俳句を楽しむ
 * ---- 読了を削除して並べ替え ----
 * 本（未読のみ）:　　　　　　← 本数が表示されていない
 *  - [1] 国語の物語
 *  - [3] 歴史入門【読了】  ← 本来は消えるべきだが残ってしまっている
 *  - [4] 宇宙のふしぎ
 *  - [5] 俳句を楽しむ
 * 最初の本:              ← 本のタイトルが表示されていない
 * 最後の本:              ← 本のタイトルが表示されていない
 *
 * ▼期待される出力（正しく修正できた場合の例）
 * 本（初期）: 5件
 *  - [1] 国語の物語
 *  - [2] 科学まんが【読了】
 *  - [3] 歴史入門【読了】
 *  - [4] 宇宙のふしぎ
 *  - [5] 俳句を楽しむ
 * ---- 読了を削除して並べ替え ----
 * 本（未読のみ）: 3
 * - [5] 俳句を楽しむ
 * - [4] 宇宙のふしぎ
 * - [1] 国語の物語
 * 最初の本: [5] 俳句を楽しむ
 * 最後の本: [1] 国語の物語
 *
 * ▼指示
 * ・(3)の【読了】を含む要素をすべて削除できるように、削除処理を改修すること。
 *   - 次のいずれかの方法でOK。
 *     (A) 後ろの要素から前へ走査する for文 で remove(i) を行う。
 *     (B) removeIf(s -> s.contains("【読了】")) を使って一括削除する。
 * ・(4)で、本リスト現在昇順になっているため、降順に並べ替えること。
 * ・最後に、「本リストの総件数」「本リストの先頭の要素」「本リストの末尾の要素」を取得して表示すること。
 * ・Main クラスのみを修正して構いません（クラスの追加は不要）。
 *
 * ▼ヒント
 * ・前から remove すると、全体の要素の順番が前に詰められて添え字が変わってしまう（今回の不具合の原因）。
 * 　そのため、後ろから remove するか、removeIf を使うとスキップが起きません。
 * ・並べ替え方法は 昇順: list.sort(Comparator.naturalOrder()); 降順: list.sort(Comparator.reverseOrder());
 * ・リストの先頭の要素はgetFirst()またはget(0)、末尾の要素はgetLast()またはget(list.size() - 1)で取得できる。
 *
 * ▼学習のねらい
 * ・リストの要素削除時に注意することを理解する。
 * ・List の基本操作（add, get, size, sort, remove, contains）の一通りの実践
 *
 */
public class Main {
  public static void main(String[] args) {
    List<String> books = new ArrayList<>();

    // (1)リストに要素（本のタイトル）を追加。
    addInitialData(books);

    // (2)リストの中身を表示。
    System.out.println("本（初期）: " + books.size() + "件");
    printAll(books);

    // (3)リスト内の要素で「【読了】」が含まれているものをリストから削除。
    books.removeIf(s -> s.contains("【読了】")); // 修正。

    // (3)の別解：後ろの要素から前へ走査する for文 で remove(i) を行う方法でもOK。
    // for (int i = books.size() - 1; i >= 0; i--) {
    //   String title = books.get(i); // get の練習
    //   if (title.contains("【読了】")) {
    //     books.remove(i);
    //   }
    // }

    System.out.println("---- 読了を削除して並べ替え ----");

    // (4)リスト内の要素を辞書順の降順に並び替える。
    books.sort(Comparator.reverseOrder()); // 修正。昇順 → 降順に直した。

    // (5)リストの中身を表示。
    System.out.println("本（未読のみ）: " + books.size()); // 修正。本リストの総件数を取得して表示。
    printAll(books);

    System.out.println("最初の本: " + books.getFirst()); // 修正。先頭の要素を取得して表示。
    System.out.println("最後の本: " + books.getLast()); // 修正。末尾の要素を取得して表示。
  }

  /**
   * 本リストリストに初期データを追加する。
   *
   * @param books 本リスト
   */
  private static void addInitialData(List<String> books) {
    books.add("[1] 国語の物語");
    books.add("[2] 科学まんが【読了】");
    books.add("[3] 歴史入門【読了】");
    books.add("[4] 宇宙のふしぎ");
    books.add("[5] 俳句を楽しむ");
  }

  /**
   * 本リストの中身をすべて表示する。
   *
   * @param books 本リスト
   */
  private static void printAll(List<String> books) {
    for (String s : books) {
      System.out.println(" - " + s);
    }
  }
}
