package FunctionMain;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionMain {

    public void main(String[] args) {
        //Function<受け取る型, 返す型> 変数名 = (入力引数) -> 戻り値を作る式/処理;
        Function<Integer, Integer> func = x -> x * x;
        //applyはFunction<T,R> が定義している 唯一の抽象メソッド（SAM）で、ラムダが実装している“本体”です。呼び出さない限り、当然実行されません。
        System.out.println(func.apply(5));

        Consumer<String> consumer = x -> System.out.println(STR."Hello\{x}");
        consumer.accept("Taro");

        List<Integer> numbers = List.of(5, 12, 8, 21, 3);
        List<Integer> filtered = numbers.stream()
                .filter(n -> n >= 10)
                .map(n -> ++n)
                .toList();

        System.out.println(filtered);

        Map<String, Integer> scores = Map.of(
                "Taro", 60,
                "Hanako", 85
        );

        scores.entrySet().stream()
                //.filter(e -> e.getValue() >= threshold)
                .filter(entry -> entry.getValue() >= 80)
                //各要素 entry に対して entry.getKey() を呼べ
                .map(Map.Entry::getKey)

                .forEach(System.out::println);
    }
}
