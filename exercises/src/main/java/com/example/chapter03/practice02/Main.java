package com.example.chapter03.practice02;

/**
 * 【問題02：信号機の不具合を直そう（インスタンス化）】
 * <p>
 * これは、信号機（TrafficLight）を作成後、その信号機の色を切り替えて、
 * 最後に「信号: 赤/黄/青」を表示するプログラムです。
 * 現在のコードには不具合があり、期待どおりの表示になりません。
 * <p>
 * ▼現在の出力結果（このプログラムをそのまま実行した場合）
 * 信号
 * <p>
 * ▼期待される出力結果
 * 信号: 青
 * 信号: 黄
 * 信号: 赤
 * <p>
 * ▼指示
 * ・TrafficLight のフィールド color の修飾子を private にしてください。
 * ・TrafficLight のコンストラクタで渡された初期色を正しくフィールドに設定してください。
 * ・TrafficLight のメソッド next() は実行するごとに「赤→青→黄→赤」の順で色が切り替わるように直してください。
 * ・TrafficLight のメソッド label() は「信号: 色の名前」の形式で返すように直してください。
 * ・Main のメソッド main() で、信号機を合計 3 つ（赤、黄、青）インスタンス化して、1回進めてから結果を表示してください。
 */
class Main {
    public static void main(String[] args) {
        // 1つ目：赤で作って1回進める → 青になる
        TrafficLight t1 = new TrafficLight("赤");
        t1.next();
        System.out.println(t1.label()); // 期待: 信号: 青

        // 以下にあなた自身でコードを追加してください。
        // 2つ目：青で作って1回進める → 黄になる（期待: 信号: 黄）
        TrafficLight t2 = new TrafficLight("青");
        t2.next();
        System.out.println(t2.label());
        // 3つ目：黄で作って1回進める → 赤になる（期待: 信号: 赤）
        TrafficLight t3 = new TrafficLight("黄");
        t3.next();
        System.out.println(t3.label());
    }
}