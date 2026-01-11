package com.example.chapter03.practice01;

/**
 * 【問題01：貯金箱の不具合を直そう（クラス内修正）】
 * <p>
 * これは、持ち主の名前を持つ「貯金箱」（PiggyBank）にお金を入れて、
 * 最後に「名前: ○○円」を表示するプログラムです。
 * 現在のコードには不具合があり、期待どおりの表示になりません。
 * <p>
 * ▼現在の出力結果（このプログラムをそのまま実行した場合）
 * 太郎
 * <p>
 * ▼期待される出力結果
 * 太郎: 150円
 * <p>
 * ▼指示
 * ・PiggyBank の フィールド ownerName, amountYen の修飾子を private にしてください。
 * ・PiggyBank の メソッド deposit(int yen) に不具合がありますので直してください。
 * ・PiggyBank の メソッド label() に不具合がありますので直してください。
 */
class Main {
    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("太郎");
        bank.deposit(100);
        bank.deposit(50);
        System.out.println(bank.label()); // 期待される出力結果は「太郎: 150円」
    }
}