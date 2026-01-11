package com.example.chapter03.practice02;

/**
 * 信号機（TrafficLight）を表すクラス。現在の色を管理して切り替えます。
 */
public class TrafficLight {
    /**
     * 現在の色（"赤" / "黄" / "青"）
     */
    private String color;


    /**
     * 初期色を指定して信号機を作ります。
     *
     * @param initialColor 初期色（"赤" / "黄" / "青"）
     */
    public TrafficLight(String initialColor) {
        validate(initialColor);
        this.color = initialColor;
    }//初期値を最初の色にする

    private static void validate(String c) {
        if (!"赤".equals(c) && !"青".equals(c) && !"黄".equals(c)) {
            throw new IllegalStateException("不正な信号の色: " + c);
        }
    }

    /**
     * 次の色へ切り替えます（赤→青→黄→赤）。
     */
    public void next() {
        validate(this.color);
        // 実装する。
        if ("赤".equals(this.color)) {
            this.color = "青";
        } else if ("青".equals(this.color)) {
            this.color = "黄";
        } else if ("黄".equals(this.color)) {
            this.color = "赤";
        }
    }

    /**
     * 表示用の文字列（例: "信号: 青"）を返します。
     *
     * @return 表示用の文字列
     */
    public String label() {
        validate(this.color);
        return "信号" + color; // ← 不具合：色が出ていない（直す）
    }
}