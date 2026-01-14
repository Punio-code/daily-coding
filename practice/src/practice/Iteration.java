package practice;

public class Iteration {
    public static void main(String[] args) {
        System.out.println("while 文章の練習");
        // while　条件を満たす間繰り返す
        //++はその位置で可算を行いそしてReturnする性質を含んでいる
        int num = 0;
        while (num < 10) {
            System.out.println(num++);
        }
        // do while　必ず1回は実行、条件が満たす間繰り返す
        int num2 = 0;
        do {
            // 初回は必ずここが実行される
            System.out.println(num2++);
        } while (num2 < 10);

        // for　決められた回数、繰り返す
        // for(初期化処理、条件式、繰り返し処理）{...
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d process%n", i);
            System.out.println(i);
            if (i > 3) {
                break;
            }
        }

        // 拡張 for   配列やﾘｽﾄの全要素を繰り返す
        String[] names = {"Taro", "Jiro", "Hanako"};

        for (String n : names) {
            System.out.println(n);
        }

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        for (int[] row : matrix) {      // ここは使える (int[] という mass を回す)
            for (int v : row) {         // ここも使える (int という entity を順番に取り出す)
                System.out.println(v);
            }
        }
        int[][] matrixTest = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("test" + matrixTest[1][1]);
        System.out.println();
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.println(v);
            }
        }
    }

}