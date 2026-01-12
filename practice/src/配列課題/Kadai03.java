package 配列課題;

/*
  【問題03：在庫数の合計を求める】
  これは、スーパーの在庫数を合計して表示するプログラムです。
  配列 stocks には各商品の在庫数が入っています。

  しかし、現在のコードのまま実行すると、
  ・合計が正しく計算されない
  ・配列の範囲外アクセスでエラーになる
  という不具合があります。

  ▼期待される出力結果
  在庫の合計: 21

  ▼指示
  ・不具合を修正して、期待される出力結果になるようにしてください。
  ・配列 stocks の中身は変更しないこと。

  ▼修正ポイント
  ・ループ条件
      誤り: for (int i = 0; i <= stocks.length; i++)
      修正: for (int i = 0; i < stocks.length; i++)
      配列の添字は 先頭の要素が0, 末尾の要素がlength-1
  ・加算式
      誤り: total =+ stocks[i];（これは「右辺に単項プラス（+）を付けた値をそのまま代入」なので累積にならない）
      修正: total += stocks[i];（加算代入）
*/
public class Kadai03 {

    public static void main(String[] args) {
        int[] stocks = {5, 3, 2, 6, 5};
        int total = 0;

        // 修正1: ループ条件を < にする（範囲外アクセス防止）
        for (int i = 0; i < stocks.length; i++) {
            total += stocks[i]; // 修正2: total =+ stocks[i] → total += stocks[i] にする
        }

        System.out.println("在庫の合計: " + total);
    }
}