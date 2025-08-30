package com.example.game.domain;

/**
 * じゃんけんの手を表現するEnum。 ROCK（グー）、PAPER（パー）、SCISSORS（チョキ）の3つの手を定義します。
 */
public enum Hand {
  /**
   * グー
   */
  ROCK(0, "グー"),
  /**
   * チョキ
   */
  SCISSORS(1, "チョキ"),
  /**
   * パー
   */
  PAPER(2, "パー");

  private final int number;
  private final String displayName;

  /**
   * コンストラクタ。
   *
   * @param number      手を表す数値
   * @param displayName 表示名
   */
  Hand(int number, String displayName) {
    this.number = number;
    this.displayName = displayName;
  }

  /**
   * 数値を取得します。
   *
   * @return 手を表す数値
   */
  public int getNumber() {
    return number;
  }

  /**
   * 表示名を取得します。
   *
   * @return 表示名
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * この手が勝つ相手の手を取得します。
   *
   * @return この手が勝つ相手の手
   */
  public Hand getWinsAgainst() {
    return switch (this) {
      case ROCK -> SCISSORS;
      case PAPER -> ROCK;
      case SCISSORS -> PAPER;
    };
  }

  /**
   * この手が負ける相手の手を取得します。
   *
   * @return この手が負ける相手の手
   */
  public Hand getLosesAgainst() {
    return switch (this) {
      case ROCK -> PAPER;
      case PAPER -> SCISSORS;
      case SCISSORS -> ROCK;
    };
  }

  /**
   * 数値から手を取得します。
   *
   * @param value 手を表す数値（0:グー, 1:チョキ, 2:パー）
   * @return 対応する手
   * @throws IllegalArgumentException 無効な値が指定された場合
   */
  public static Hand fromInt(int value) {
    for (Hand hand : Hand.values()) {
      if (hand.getNumber() == value) {
        return hand;
      }
    }
    throw new IllegalArgumentException("手の値が無効です: " + value);
  }

  /**
   * この手と相手の手で勝敗を決定します。
   *
   * @param opponent 相手の手
   * @return ゲームの結果（勝ち、負け、引き分け）
   */
  public GameResult decideOutcome(Hand opponent) {
    if (this == opponent) {
      return GameResult.DRAW;
    }
    if (this.getWinsAgainst() == opponent) {
      return GameResult.WIN;
    }
    return GameResult.LOSE;
  }

  /**
   * 手の種類数を取得します。
   *
   * @return 手の種類数
   */
  public static int getHandCount() {
    return Hand.values().length;
  }

  /**
   * 入力可能な手の詳細を取得します。
   *
   * @return 手の入力ガイド文字列
   */
  public static String getInputGuide() {
    StringBuilder guide = new StringBuilder();
    for (int i = 0; i < getHandCount(); i++) {
      Hand hand = Hand.values()[i];
      if (i > 0) {
        guide.append(", ");
      }
      guide.append(hand.getNumber()).append(":").append(hand.getDisplayName());
    }
    return guide.toString();
  }
}