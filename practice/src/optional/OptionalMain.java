package optional;

import java.util.Optional;
import java.util.Scanner;

public class OptionalMain {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Optional<String> userNameOptional = getUserName(sc);

            // 動作確認
            System.out.println("返却値: " + userNameOptional);
            System.out.println("orElse: " + userNameOptional.orElse("(no name)"));
            System.out.println("orElseget: " + userNameOptional.orElseGet(() -> "unknown"));
            System.out.println("orElseThrow: " + userNameOptional.orElseThrow());
            System.out.println(
                    userNameOptional
                            .map(String::toUpperCase)
                            .map(e -> "map : " + e)
                            .get()
            );
            // ifPresent の例
            userNameOptional.ifPresent(name -> System.out.println("ifPresent : こんにちは " + name));


        }
    }

    public static Optional<String> getUserName(Scanner sc) {
        System.out.print("ユーザー名を返しますか？ (1: empty / 2: Taro) > ");
        String input = sc.nextLine().trim();

        return switch (input) {
            case "1" -> Optional.empty();
            case "2" -> Optional.of("Taro");
            default -> {
                System.out.println("不正入力なので empty を返します。");
                yield Optional.empty();
            }
        };
    }
}

