package com.example.chapter03.practice01;

/**
 * 貯金箱（PiggyBank）を表すクラス。
 * 持ち主の名前と、現在の合計金額（円）を管理します。
 */
public class PiggyBank {

    /**
     * 持ち主の名前
     */
    private String ownerName;

    /**
     * 合計金額（円）
     */
    private int amountYen;

    /**
     * 持ち主の名前を指定して貯金箱を作ります。
     *
     * @param ownerName 持ち主の名前
     */
    public PiggyBank(String ownerName) {
        this.ownerName = ownerName;
        this.amountYen = 0;
    }

    /**
     * お金を入れて貯金額を増やします。
     *
     * @param yen 入れる金額（円）
     */
    public void deposit(int yen) {
        this.amountYen += yen;
    }

    /**
     * ラベル用の文字列を返します。
     * 例: 「太郎: 150円」
     *
     * @return 表示用の文字列
     */
    public String label() {
        return this.ownerName + " : " + this.amountYen + " yen";
    }
}