package com.example.game.domain;

import com.example.game.exception.InvalidHandException;
import java.util.Random;
import java.util.Scanner;

/**
 * 手の生成を担当するファクトリクラス。 プレイヤーの手の入力とコンピュータの手の生成を行います。 AutoCloseableを実装し、Scannerのリソース管理を行います。
 */
public class HandFactory implements AutoCloseable {

  private final Scanner scanner;
  private final Random random;

  /**
   * コンストラクタ。 ScannerとRandomのインスタンスを初期化します。
   */
  public HandFactory() {
    this.scanner = new Scanner(System.in);
    this.random = new Random();
  }

  /**
   * プレイヤーの手を取得します。 標準入力から数値を受け取り、対応する手を返します。
   *
   * @return プレイヤーの手
   * @throws InvalidHandException 無効な入力が行われた場合
   */
  public Hand getPlayerHand() throws InvalidHandException {
    System.out.print("手を入力してください（" + Hand.getInputGuide() + "）: ");
    String input = scanner.nextLine();

    return validateInput(input);
  }

  /**
   * コンピュータの手を生成します。 ランダムに手を選択して返します。
   *
   * @return コンピュータの手
   */
  public Hand getComputerHand() {
    return Hand.fromInt(random.nextInt(Hand.getHandCount()));
  }

  /**
   * 入力値を検証します。 文字列を数値に変換し、有効な手に変換します。
   *
   * @param input 入力文字列
   * @return 検証済みの手
   * @throws InvalidHandException 無効な入力の場合
   */
  private Hand validateInput(String input) throws InvalidHandException {
    int value;
    try {
      value = Integer.parseInt(input.trim());
    } catch (NumberFormatException e) {
      throw new InvalidHandException("数字を入力してください。");
    }

    try {
      return Hand.fromInt(value);
    } catch (IllegalArgumentException e) {
      throw new InvalidHandException("正しい数字を入力してください。（" + Hand.getInputGuide() + "）");
    }
  }

  /**
   * リソースをクローズします。 Scannerを安全にクローズします。
   */
  @Override
  public void close() {
    scanner.close();
  }
}