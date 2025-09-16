package com.example.chapter09.practice05;

/**
 * 過去日付での予約を禁止するための例外。
 */
public class PastDateBookingException extends RuntimeException { // 追加。非チェック例外にするため RuntimeException を継承。
  public PastDateBookingException(String message) { // コンストラクタを追加。
    super(message); // 追加。親クラスのコンストラクタを呼び出している。
  }
}
