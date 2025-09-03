package com.example.game.domain;

/**
 * ゲームの結果を表現するEnum。 WIN（勝ち）、LOSE（負け）、DRAW（引き分け）の3つの結果を定義します。
 */
public enum GameResult {
  /**
   * 勝ち
   */
  WIN("あなたの勝ち！"),
  /**
   * 負け
   */
  LOSE("あなたの負け…"),
  /**
   * 引き分け
   */
  DRAW("あいこです。もう一度！");

  private final String message;

  /**
   * コンストラクタ。
   *
   * @param message 結果メッセージ
   */
  GameResult(String message) {
    this.message = message;
  }

  /**
   * 結果メッセージを取得します。
   *
   * @return 結果メッセージ
   */
  public String getMessage() {
    return message;
  }
}