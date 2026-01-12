package com.example.chapter03.practice04;

public class PizzaBox {
    /**
     * 残りスライス数（0〜8）
     */
    private int slices;

    /**
     * コンストラクタ。
     * 指定された枚数でピザを用意します。範囲外の場合はガード処理を行います。
     *
     * @param initialSlices 初期のスライス数
     */
    public PizzaBox(int initialSlices) {
        setSlices(initialSlices);
    }

    private void setSlices(int value) {
        if (value < 0) {
            this.slices = 0;
        } else if (value > 8) {
            this.slices = 8;
        } else {
            this.slices = value;
        }
    }
}