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

    /*
      コンストラクタ 終わり
     */

    /**
     * Setter。
     */
    private void setSlices(int value) {
        if (value < 0) {
            this.slices = 0;
        } else if (value > 8) {
            this.slices = 8;
        } else {
            this.slices = value;
        }
    }


    //メソッドの仕様：count（0 以上）だけスライスを減らす。結果は 0 未満にならないように 0 で止める。
    //count < 0 が来た場合は何もしなくてよい。
    public void eat(int count) {
        if (count < 0) {
            return;
        }
        setSlices(this.slices - count);
    }

    /**
     * @return 「残りX切れ」
     */
    public String label() {
        return "残り: " + this.slices + "切れ";
    }
}
