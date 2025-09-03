package com.example.game.service;

import com.example.game.domain.GameResult;
import com.example.game.domain.Hand;
import com.example.game.domain.HandFactory;
import com.example.game.exception.InvalidHandException;

/**
 * じゃんけんゲームのサービスクラス。ゲームの全体的な流れを制御し、プレイヤーとコンピュータの対戦を管理します。
 */
public class RockPaperScissorsService {

  private final HandFactory handFactory;

  /**
   * コンストラクタ。
   */
  public RockPaperScissorsService() {
    this.handFactory = new HandFactory();
  }

  /**
   * じゃんけんゲームを実行します。プレイヤーの入力を受け取り、コンピュータと対戦し、勝敗が決まるまで繰り返します。
   */
  public void playGame() {
    System.out.println("=== じゃんけんゲーム ===");

    try (HandFactory factory = handFactory) {
      while (true) {
        try {
          // ユーザーとコンピュータの手を用意する。
          Hand playerHand = factory.getPlayerHand();
          Hand computerHand = factory.getComputerHand();
          showHands(playerHand, computerHand);

          // じゃんけんの勝敗を決めて結果を出力する。
          GameResult result = playerHand.decideOutcome(computerHand);
          showResult(result);

          if (result != GameResult.DRAW) {
            // 勝敗がついたら終了する。
            break;
          }
        } catch (InvalidHandException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }

  /**
   * プレイヤーとコンピュータの手を表示します。
   *
   * @param playerHand   プレイヤーの手
   * @param computerHand コンピュータの手
   */
  private void showHands(Hand playerHand, Hand computerHand) {
    System.out.println("あなたの手: " + playerHand.getDisplayName());
    System.out.println("コンピュータの手: " + computerHand.getDisplayName());
  }

  /**
   * ゲームの結果を表示します。
   *
   * @param result ゲームの結果
   */
  private void showResult(GameResult result) {
    System.out.println(result.getMessage());
  }
}