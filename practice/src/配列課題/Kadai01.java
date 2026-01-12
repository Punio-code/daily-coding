package 配列課題;

/*
  【問題01：最高気温を求める】
  これは、配列 temps の中の最大値（最高気温）を求めて表示するプログラムです。
  しかし、現在のコードのまま実行すると、最大値（最高気温）ではない値が表示されてしまいます。

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  最高気温: 0.0℃

  ▼期待される出力結果
  最高気温: 21.0℃

  ▼指示
  ・コードを修正し、期待される出力になるようにしてください。
  ・配列 temps の中身は変更しないこと。

  ▼修正ポイント
  元のコードは if (max > temps[i]) で「小さければ更新」になっていた。
  正しくは if (max < temps[i]) にして「大きければ更新」。
*/
public class Kadai01 {

    public static void main(String[] args) {
        double[] temps = {18.5, 20.0, 19.2, 21.0, 17.8};
        double max = 0;

        for (int i = 0; i < temps.length; i++) {
            if (max < temps[i]) { // 修正: 「より大きければ更新」に条件を直す
                max = temps[i];
            }
        }
        System.out.println("最高気温: " + max + "℃");
    }
}