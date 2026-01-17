package exeception;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    // 疑似スタックフレーム（= 呼び出しの枠）を自前で管理する
    private static final Deque<String> pseudoFrames = new ArrayDeque<>();

    private static void enter(String frameName) {
        pseudoFrames.push(frameName);
        System.out.println("ENTER  " + frameName + " | frames=" + pseudoFrames);
    }

    private static void exit(String frameName) {
        // stack top を pop する（frameName は整合性確認に使ってもよいが、ここではログ用途）
        String popped = pseudoFrames.pop();
        System.out.println("EXIT   " + popped + " | frames=" + pseudoFrames);
    }

    public static void main(String[] args) {

        // --- 1) 配列の範囲外アクセス例 ---
        int[] numbers = {1, 2, 3};

        try {
            System.out.println(numbers[5]);
            System.out.println("Objection"); // ここは実行されない
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Accessed an array index out of bounds: " + e.getMessage());
        }
        System.out.println("over ruled");

        // --- 2) 入力値チェック例（負なら例外） ---
        Scanner scanner = new Scanner(System.in);
        System.out.println("input Int");
        int number = scanner.nextInt();

        if (number < 0) {
            try {
                throw new IllegalArgumentException("The input must be a non-negative integer: " + number);
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException caught: " + e.getMessage());
            }
        } else {
            System.out.println("Input Value is: " + number);
        }

        scanner.close();

        // --- 3) 例外伝播 + 巻き戻し（疑似フレーム表示） ---
        System.out.println("=== propagation / unwinding demo ===");

        enter("main()"); // 疑似フレーム開始
        System.out.println("main: start");

        try {
            service();
            System.out.println("main: after service (not executed if exception occurs)");
        } catch (IllegalStateException e) {
            System.out.println("main: caught -> " + e.getClass().getSimpleName()
                    + " : " + e.getMessage());

            // 参考：本物のスタックトレース（JVMが保持する情報）
            System.out.println("---- real stack trace ----");
            e.printStackTrace(System.out);
            System.out.println("--------------------------");
        } finally {
            System.out.println("main: finally (before unwind exit)");
            exit("main()");
        }

        System.out.println("main: end");
    }

    static void service() {
        enter("service()");
        System.out.println("service: start");

        try {
            repository();
            System.out.println("service: end (not executed if exception occurs)");
        } finally {
            System.out.println("service: finally (unwinding point if exception)");
            exit("service()");
        }
    }

    static void repository() {
        enter("repository()");
        System.out.println("repository: start");

        try {
            validate();
            System.out.println("repository: end (not executed if exception occurs)");
        } finally {
            System.out.println("repository: finally (unwinding point if exception)");
            exit("repository()");
        }
    }

    static void validate() {
        enter("validate()");
        System.out.println("validate: start");

        try {
            throw new IllegalStateException("validation failed");
        } finally {
            System.out.println("validate: finally (unwinding starts here)");
            exit("validate()");
        }
    }
}
