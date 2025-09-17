package com.example.chapter11;

import java.util.Objects;

/**
 * 氏名を表すクラス。
 */
public final class FullName {

  /**
   * 名
   */
  private final String firstName;

  /**
   * 姓
   */
  private final String lastName;

  /**
   * コンストラクタ。
   *
   * @param firstName 名
   * @param lastName 姓
   */
  public FullName(String firstName, String lastName) {
    this.firstName = Objects.requireNonNull(firstName);
    this.lastName = Objects.requireNonNull(lastName);
  }

  /**
   * 名を返す。
   *
   * @return 名
   */
  public String firstName() {
    return firstName;
  }

  /**
   * 姓を返す。
   *
   * @return 姓
   */
  public String lastName() {
    return lastName;
  }

  /**
   * 「姓 名」というフォーマットの文字列で返す。
   *
   * @return 「姓 名」というフォーマットの文字列
   */
  public String formatted() {
    return lastName + " " + firstName;
  }
}