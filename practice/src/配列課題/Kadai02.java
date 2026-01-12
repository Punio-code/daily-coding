package 配列課題;

/*
  【問題02：平均点と合格者数を求める】
  これは、配列 scores の平均点を計算し、60点以上の合格者数を表示するプログラムです。
  しかし、現在のコードのまま実行すると、無効な点数（例：-1 や 100を超える値）まで計算に含めてしまい、
  実データの平均・合格者数と異なる結果を表示してしまいます。

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  平均: 61
  合格者数: 4
  有効な点数の数: 7
  無効な点数の数: 0

  ▼期待される出力結果
  平均: 66
  合格者数: 3
  有効な点数の数: 5
  無効な点数の数: 2

  ▼指示
  ・scores の中で「0〜100」の範囲にない値（-1 や 101 など）は、平均計算・合格判定の対象から除外してください。
  ・平均は「有効な点数の件数」で割ってください（割った結果の小数点については切り捨てでOK）。
  ・配列 scores の中身は変更しないこと。
  ・必要であれば continue を使っても良い（使わなくても良い）。

  ▼修正ポイント
  ・無効な値であるかのチェックを追加
      if (s < 0 || s > 100) で判定し、invalidCount++ して continue でスキップ。
  ・有効値と無効値のカウント
      有効値のときだけ sum と validCount を加算する。
      無効値は invalidCount を加算する。
  ・平均の分母を修正
      scores.length ではなく、有効件数 validCount で割る。
*/
public class Kadai02 {

    public static void main(String[] args) {
        int[] scores = {55, 70, -1, 90, 35, 80, 101}; // -1, 101: 無効
        int sum = 0;          // 有効点数の合計
        int passedCount = 0;  // 合格者数
        int validCount = 0;   // 有効点数の件数
        int invalidCount = 0; // 無効点数の件数

        for (int s : scores) {
            // 修正: 無効な値であるかをチェックする
            if (s < 0 || s > 100) {
                invalidCount++;
                continue; // 無効な値はスキップ
            }

            sum += s;
            validCount++;

            if (s >= 60) {
                passedCount++;
            }
        }

        int avg = sum / validCount; // 修正: 平均は有効点数で割る

        System.out.println("平均: " + avg);
        System.out.println("合格者数: " + passedCount);
        System.out.println("有効な点数の数: " + validCount);
        System.out.println("無効な点数の数: " + invalidCount);
    }
}