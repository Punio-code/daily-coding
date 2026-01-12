package com.example.chapter04;

/**
 * カレンダーの予定（Event）を表すクラス。
 * タイトル・所要時間・場所を管理します。
 */
public class Event {

  /**
   * デフォルトのタイトル
   */
  private static final String DEFAULT_TITLE = "no title";

  /**
   * デフォルトの所要時間（分）
   */
  private static final int DEFAULT_MINUTES = 30;

  /**
   * デフォルトの場所
   */
  private static final String DEFAULT_LOCATION = "オンライン";

  /**
   * タイトル（例: 相談）
   */
  private String title; // 修正（public → private）

  /**
   * 所要時間（分）
   */
  private int minutes; // 修正（public → private）

  /**
   * 場所（例: オンライン）
   */
  private String location; // 修正（public → private）

  /**
   * 作成された予定（Event）の総数
   */
  static int totalEvents = 0;

  /**
   * コンストラクタ。
   * デフォルトの予定を作成する。
   */
  public Event() {
     // this.title = DEFAULT_TITLE;
     // this.minutes = DEFAULT_MINUTES;
     // this.location = DEFAULT_LOCATION;

    // 修正。こう実装することも可能。引数を3つ持つコンストラクタを呼び出している。
    this(DEFAULT_TITLE, DEFAULT_MINUTES, DEFAULT_LOCATION);
  }

  /**
   * コンストラクタ。
   * タイトルは引数の値を設定する。
   * 所要時間と場所はデフォルト値を設定する。
   *
   * @param title タイトル
   */
  public Event(String title) {
    // this.title = title;
    // this.minutes = DEFAULT_MINUTES;
    // this.location = DEFAULT_LOCATION;

    // 修正。こう実装することも可能。引数を3つ持つコンストラクタを呼び出している。
    this(title, DEFAULT_MINUTES, DEFAULT_LOCATION);
  }

  /**
   * コンストラクタ。
   * タイトルと所要時間は引数の値を設定する。
   * 場所はデフォルト値を設定する。
   *
   * @param title タイトル
   * @param minutes 所要時間
   */
  public Event(String title, int minutes) {
    // 修正
    this(title, minutes, DEFAULT_LOCATION);
  }

  /**
   * コンストラクタ。
   * タイトルと所要時間と場所は引数の値を設定する。
   *
   * @param title タイトル
   * @param minutes 所要時間
   */
  public Event(String title, int minutes, String location) {
    this.title = title;       // 追加
    this.minutes = minutes;   // 追加
    this.location = location; // 追加
    totalEvents++;            // 追加。Eventインスタンスが作成された数をカウントしている。
  }

  /**
   * 所要時間を 15分 加算する。
   */
  public void addMinutes() {
    this.minutes += 15; // 追加
  }

  /**
   * 所要時間を 引数に与えられた値（分） 加算する。
   *
   * @param minutes 所要時間
   */
  public void addMinutes(int minutes) {
    this.minutes += minutes; // 追加
  }

  /**
   * 表示用の文字列を取得する。
   * （例: "予定: 予定のタイトル, 所要時間: 45分, 場所: オンライン"）
   *
   * @return 表示用の文字列
   */
  public String label() {
    return "予定: " + this.title + ", 所要時間: " + this.minutes + "分, 場所: " + this.location; // 修正
  }

  /**
   * カレンダーの予定の総数を取得する。
   *
   * @return カレンダーの予定の総数
   */
  public static int getTotalEvents() {
    return totalEvents;
  }
}