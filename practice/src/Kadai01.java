/*
  【問題01：合格判定（if文と論理演算子）】
  これは、点数（score） と 出席率（attendance）を使って「合格 / 不合格」を判定するプログラムです。
  合格の条件は「score が 60点以上 かつ attendance が 0.8（80%）以上」です。
  しかし、現在のコードのまま実行すると、想定と異なる結果が表示されてしまいます。

  ▼現在の出力結果（このプログラムをそのまま実行した場合）
  判定結果: 合格

  ▼期待される出力結果
  判定結果: 不合格

  ▼指示
  ・if文の条件式を修正し、期待される出力になるようにしてください。
  ・score と attendance の値は変更しないこと。
*/
public class Kadai01 {

    public static void main(String[] args) {
        int score = 75;
        double attendance = 0.7;

        String result;
        if (score >= 60 && attendance >= 0.8) {
            result = "合格";
        } else {
            result = "不合格";
        }

        System.out.println("判定結果: " + result);
    }
}
