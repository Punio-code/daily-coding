package com.example.game;

import com.example.game.service.RockPaperScissorsService;

/**
 * じゃんけんゲームのメインクラス。アプリケーションのエントリーポイントを提供します。
 */
public class Main {

  /**
   * アプリケーションのエントリーポイント。じゃんけんゲームを開始します。
   *
   * @param args コマンドライン引数（使用しない）
   */
  public static void main(String[] args) {
    RockPaperScissorsService service = new RockPaperScissorsService();
    service.playGame();
  }
}
