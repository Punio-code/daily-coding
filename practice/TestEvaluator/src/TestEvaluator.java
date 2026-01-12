import java.util.Scanner;

public class TestEvaluator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score;

        while (true) {
            System.out.print("点数を入力してください（0～100）: ");

            if (!sc.hasNextInt()) {
                System.out.println("エラー: 数値で入力してください。");
                sc.next(); // 数値以外の入力を破棄
                continue;
            }

            score = sc.nextInt();

            if (score < 0 || score > 100) {
                System.out.println("エラー: 0～100 の範囲で入力してください。");
                continue;
            }

            break; // 正常入力ならループ終了
        }

        // 判定ロジック
        if (score >= 80) {
            System.out.println("大変よくできました！");
        } else if (score >= 60) {
            System.out.println("合格です！");
        } else {
            System.out.println("不合格です。再テストを行いましょう。");
        }

        sc.close();
    }
}