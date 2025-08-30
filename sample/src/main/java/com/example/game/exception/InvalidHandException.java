package com.example.game.exception;

/**
 * 無効な手が入力された場合の例外クラスです。ユーザーが不正な値を入力した際にスローされます。
 */
public class InvalidHandException extends Exception {

  /**
   * 指定されたメッセージでInvalidHandExceptionを構築します。
   *
   * @param message 例外メッセージ
   */
  public InvalidHandException(String message) {
    super(message);
  }
}