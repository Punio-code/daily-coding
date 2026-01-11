package com.example.chapter02;

/*
  【問題06：果物の在庫チェック】
  スーパーの果物売り場の在庫を調べています。
  配列 fruits には「果物名: 在庫数」が文字列として入っています。
  例: "りんご:5" は「りんごが5個ある」という意味です。

  すべての要素を拡張for文で処理し、在庫数が 3 以下の果物だけを
  「在庫わずか」として表示してください。

  ▼期待される出力結果
  在庫わずか: バナナ（2個）
  在庫わずか: いちご（1個）

  ▼指示
  ・拡張for文を使って配列を走査してください（普通のfor文は使わないこと）。
  ・文字列を「:」で分割して果物名と在庫数を取り出してください。
  ・在庫数が 3 以下のものだけを表示してください。
  ・出力形式は期待される出力に合わせること。
*/
public class Kadai06 {

    public static void main(String[] args) {
        String[] fruits = {"りんご:5", "バナナ:2", "みかん:10", "いちご:1"};

        // ここに拡張for文を書いて完成させる
        for (String fruit : fruits) {
            // parts [0] :parts[1] =  fruit : number
            String[] parts = fruit.split(":");
            String name = parts[0];
            int stock = Integer.parseInt(parts[1]);
            //
            if (stock <= 3) {
                System.out.println("在庫わずか: " + name + "（" + stock + "個）");
            }
        }
    }
}