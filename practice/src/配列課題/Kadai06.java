package 配列課題;

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

  ▼修正ポイント
  ・拡張for文の利用
      修正: for (String fruit : fruits) と書き、要素を直接取り出す。
  ・文字列の分割
      誤りがちな例: "りんご:5" をそのまま Integer.parseInt しようとするとエラー（例外発生）になる。
      修正: split(":") を使って "りんご" と "5" に分ける。
  ・数値変換
      修正: Integer.parseInt(parts[1]) で文字列を数値に変換。
  ・条件分岐
      修正: if (stock <= 3) で在庫が少ない果物だけを出力。
*/
public class Kadai06 {

    public static void main(String[] args) {
        String[] fruits = {"りんご:5", "バナナ:2", "みかん:10", "いちご:1"};

        // 拡張for文で配列を走査
        for (String fruit : fruits) {
            // 「:」で分割して果物名と在庫数を取り出す
            String[] parts = fruit.split(":");
            String name = parts[0];
            int stock = Integer.parseInt(parts[1]);

            // 在庫が3以下なら表示
            if (stock <= 3) {
                System.out.println("在庫わずか: " + name + "（" + stock + "個）");
            }
        }
    }
}