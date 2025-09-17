package com.example.chapter11;

import java.util.Objects;
import java.util.Optional;

/**
 * ユーザーを表すクラス。
 */
public final class User {

  /**
   * ID
   */
  private final String id;

  /**
   * 氏名
   */
  private final FullName name;

  /**
   * 年齢
   */
  private final Optional<Integer> age;

  /**
   * メールアドレス
   */
  private final Optional<String> email;

  /**
   * 住所（都市。例: 東京, San Francisco）
   */
  private final Optional<String> city;

  /**
   * コンストラクタ。
   *
   * @param id ID
   * @param name 氏名
   * @param age 年齢
   * @param email メールアドレス
   * @param city 住所
   */
  public User(
      String id,
      FullName name,
      Optional<Integer> age,
      Optional<String> email,
      Optional<String> city
  ) {
    this.id = Objects.requireNonNull(id);
    this.name = Objects.requireNonNull(name);
    this.age = (age == null) ? Optional.empty() : age;
    this.email = (email == null) ? Optional.empty() : email;
    this.city = (city == null) ? Optional.empty() : city;
  }

  /**
   * IDを返す。
   *
   * @return ID
   */
  public String id() {
    return id;
  }

  /**
   * 氏名を返す。
   *
   * @return 氏名
   */
  public FullName name() {
    return name;
  }

  /**
   * 年齢を返す。
   * 値がない場合は、Optional.empty()を返す。
   *
   * @return 年齢
   */
  public Optional<Integer> age() {
    return age;
  }

  /**
   * メールアドレスを返す。
   * 値がない場合は、Optional.empty()を返す。
   *
   * @return メールアドレス
   */
  public Optional<String> email() {
    return email;
  }

  /**
   * 住所（都市）を返す。
   * 値がない場合は、Optional.empty()を返す。
   *
   * @return 住所（都市）
   */
  public Optional<String> city() {
    return city;
  }
}