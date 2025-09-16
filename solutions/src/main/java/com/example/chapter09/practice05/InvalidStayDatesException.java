package com.example.chapter09.practice05;

/**
 * チェックアウト日がチェックイン日より前など、宿泊日の関係が不正な場合の例外。
 */
public class InvalidStayDatesException extends RuntimeException { // 追加。非チェック例外にするため RuntimeException を継承。
  public InvalidStayDatesException(String message) { // コンストラクタを追加。
    super(message); // 追加。親クラスのコンストラクタを呼び出している。
  }
}