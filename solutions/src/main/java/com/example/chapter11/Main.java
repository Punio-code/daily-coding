package com.example.chapter11;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Optional のよく使うメソッドを一気に練習できる 15 問。
 *
 * ルール:
 * - 各セクションの「// 以下に回答コードを書いてください」の下だけ編集してください。
 * - 実装は Optional を用いること。
 * - 出力内容はコメントの "▼期待する出力結果" を参考にしてください（順不同と書いてあるものは順不同OK）。
 */
public class Main {
  public static void main(String[] args) {

    /*
      ==========================
      1問目: Optionalの生成 of / empty / ofNullable
      
      文字列 name の Optional を3通りで生成して、中身がある場合のみ表示してください。
      null のときは何も表示しないでください（ifPresent）。

      ▼期待する出力結果
      Alice
      Alice
      ==========================
    */
    System.out.println("【1問目】of / empty / ofNullable");
    String name = "Alice";

    // 以下に回答コードを書いてください
    Optional<String> a = Optional.of(name);
    Optional<String> b = Optional.empty();
    Optional<String> c = Optional.ofNullable(name);
    a.ifPresent(System.out::println);
    b.ifPresent(System.out::println);
    c.ifPresent(System.out::println);

    /*
      ==========================
      2問目: isPresent / isEmpty / get
      
      age1, age2 の値の有無で「年齢あり/年齢なし」と表示してください。
      あえて ifPresent は使わず、
      age1 は isPresent を使い、
      age2 は isEmpty を使って値の有無を判定してください。

      ▼期待する出力結果
      年齢あり: 20
      年齢なし
      ==========================
    */
    System.out.println("\n【2問目】isPresent / isEmpty");
    Optional<Integer> age1 = Optional.of(20);
    Optional<Integer> age2 = Optional.empty();

    // 以下に回答コードを書いてください
    if (age1.isPresent()) {
      System.out.println("年齢あり: " + age1.get());
    } else {
      System.out.println("年齢なし");
    }

    if (age2.isEmpty()) {
      System.out.println("年齢なし");
    } else {
      System.out.println("年齢あり: " + age2.get());
    }

    /*
      ==========================
      3問目: map
      
      title1, title2 内の値を大文字に変換して表示してください。
      空の場合は何も表示しないでください。

      ▼期待する出力結果
      JAVA
      ==========================
    */
    System.out.println("\n【3問目】map");
    Optional<String> title1 = Optional.of("java");
    Optional<String> title2 = Optional.empty();

    // 以下に回答コードを書いてください
    title1.map(String::toUpperCase).ifPresent(System.out::println);
    title2.map(String::toUpperCase).ifPresent(System.out::println);

    /*
      ==========================
      4問目: filter

      email1, email2 が "@" を含むときだけ表示してください。
      含まなければ何も表示しないでください。

      ▼期待する出力結果
      foo@example.com
      ==========================
    */
    System.out.println("\n【4問目】filter");
    Optional<String> email1 = Optional.of("foo@example.com");
    Optional<String> email2 = Optional.of("foo-example.com");

    // 以下に回答コードを書いてください
    email1.filter(s -> s.contains("@")).ifPresent(System.out::println);
    email2.filter(s -> s.contains("@")).ifPresent(System.out::println);

    /*
      ==========================
      5問目: orElse と orElseGet の違い

      Optionalの変数の中身が空のときだけ、重い計算 heavy() を呼び出して既定値5を表示するようにしてください。

      ▼orElse(T other)
      括弧の中の処理は、Optional の中身が存在する場合でも必ず実行されます。
      ▼orElseGet(Supplier<? extends T> supplier)
      Optional の中身が空のときだけ supplier.get() が実行されます（遅延評価）。

      つまりorElseではなくorElseGetを使うことで、不要な呼び出しを避けることができます。

      ▼期待する出力結果（heavy() が呼ばれたときだけ "heavy called" と出力される想定）
      value=10
      heavy called
      value=5
      ==========================
    */
    System.out.println("\n【5問目】orElse vs orElseGet");
    Optional<Integer> discount1 = Optional.of(10);
    Optional<Integer> discount2 = Optional.empty();
    Supplier<Integer> heavy = () -> {
      System.out.println("heavy called");
      return 5;
    };

    // 以下に回答コードを書いてください
    System.out.println("value=" + discount1.orElseGet(heavy));
    System.out.println("value=" + discount2.orElseGet(heavy));

    /*
      ==========================
      6問目: orElseThrow（標準例外でOK）

      Optional<String> token から値を取得して表示してください。無ければ IllegalStateException を投げてください。
      ※この問題で例外が投げられるとこれ以降の問題のプログラムが実行されないため、解いたらコメントアウトなどすることをオススメします。

      ▼期待する出力結果
      abc123
      （2つ目は例外が投げられる）
      ==========================
    */
    System.out.println("\n【6問目】orElseThrow");
    Optional<String> token1 = Optional.of("abc123");
    Optional<String> token2 = Optional.empty();

    // 以下に回答コードを書いてください
    try {
      System.out.println(token1.orElseThrow(IllegalStateException::new));
      System.out.println(token2.orElseThrow(IllegalStateException::new)); // ここで例外
    } catch (IllegalStateException e) {
      System.out.println("(例外発生: " + e.getClass().getSimpleName() + ")");
    }

    /*
      ==========================
      7問目: ifPresentOrElse

      Optional<String> nickname に値があれば "Hi, <name>" を、無ければ "名無し" と表示してください。

      ▼期待する出力結果
      Hi, Bob
      名無し
      ==========================
    */
    System.out.println("\n【7問目】ifPresentOrElse");
    Optional<String> nickname1 = Optional.of("Bob");
    Optional<String> nickname2 = Optional.empty();

    // 以下に回答コードを書いてください
    nickname1.ifPresentOrElse(
        n -> System.out.println("Hi, " + n),
        () -> System.out.println("名無し")
    );

    nickname2.ifPresentOrElse(
        n -> System.out.println("Hi, " + n),
        () -> System.out.println("名無し")
    );

    /*
      ==========================
      8問目: flatMap（ネストした Optional の平坦化）

      Optional<Optional<String>> source を 1 段にして中身を表示してください。

      ▼期待する出力結果
      inner
      ==========================
    */
    System.out.println("\n【8問目】flatMap");
    Optional<Optional<String>> nested = Optional.of(Optional.of("inner"));

    // 以下に回答コードを書いてください
    nested.flatMap(x -> x)
        .ifPresent(System.out::println);

    /*
      ==========================
      9問目: Optional.stream（List<Optional<T>> から T を取り出す）

      nameOptList から非空要素だけ取り出して表示してください（順不同OK）。

      ▼期待する出力結果（順不同）
      Alice
      Carol
      Dave
      ==========================
    */
    System.out.println("\n【9問目】Optional.stream");
    List<Optional<String>> nameOptList = List.of(
        Optional.of("Alice"),
        Optional.empty(),
        Optional.of("Carol"),
        Optional.of("Dave")
    );

    // 以下に回答コードを書いてください
    nameOptList.stream()
        .flatMap(Optional::stream)
        .forEach(System.out::println);

    /*
      ==========================
      10問目: Stream の結果と Optional の組み合わせ

      values から最大値を Optional<Integer> として受け取り、あれば "max=.." を表示してください。

      ▼期待する出力結果
      max=9
      ==========================
    */
    System.out.println("\n【10問目】stream の max と Optional");
    List<Integer> values = List.of(1, 9, 3, 4);

    // 以下に回答コードを書いてください
    values.stream()
        .max(Integer::compareTo)
        .ifPresent(max -> System.out.println("max=" + max));

    /*
      ==========================
      11問目: ofNullable と Map#get の相性

      Map<String, String> prefectureMap から "Tokyo", "Atlantis" に対応する都道府県を Optional で取り出し、
      存在すれば、「キー -> 値」の形式で表示し、
      存在しなければ、「キー -> 不明」と表示してください。

      ▼期待する出力結果
      Tokyo -> 東京都
      Atlantis -> 不明
      ==========================
    */
    System.out.println("\n【11問目】ofNullable x Map#get");
    Map<String, String> prefectureMap = Map.of("Tokyo", "東京都", "Osaka", "大阪府");

    // 以下に回答コードを書いてください
    List.of("Tokyo", "Atlantis")
        .forEach(key ->
            Optional.ofNullable(prefectureMap.get(key))
                .ifPresentOrElse(
                    v -> System.out.println(key + " -> " + v),
                    () -> System.out.println(key + " -> 不明")
                )
        );

    /*
      ==========================
      12問目: ネストしたオブジェクトから安全に city を取得

      Optional を使って user.city を安全に取り出し、値があればそのまま表示し、値がなければ "unknown" と表示してください。

      ▼期待する出力結果
      Tokyo
      unknown
      ==========================
    */
    System.out.println("\n【12問目】ネストの安全参照");
    User u1 = new User("1", new FullName("Taro", "Yamada"), Optional.of(30), Optional.empty(), Optional.of("Tokyo"));
    User u2 = new User("2", new FullName("Hanako", "Sato"), Optional.empty(), Optional.empty(), Optional.empty());

    // 以下に回答コードを書いてください
    System.out.println(u1.city().orElse("unknown"));
    System.out.println(u2.city().orElse("unknown"));

    /*
      ==========================
      13問目: filter + orElseThrow でバリデーション

      Optional<String> code に対して、長さが 4 の英数字の場合のみ表示してください。
      違反時は IllegalArgumentException を投げてください。
      ※この問題で例外が投げられるとこれ以降の問題のプログラムが実行されないため、解いたらコメントアウトなどすることをオススメします。

      ▼期待する出力結果
      OK: A1b2
      （2つ目は例外）
      ==========================
    */
    System.out.println("\n【13問目】バリデーション");
    Optional<String> codeOk = Optional.of("A1b2");
    Optional<String> codeNg = Optional.of("###");

    // 以下に回答コードを書いてください
    try {
      String ok = codeOk.filter(s -> s.matches("[A-Za-z0-9]{4}"))
          .orElseThrow(IllegalArgumentException::new);
      System.out.println("OK: " + ok);

      String ng = codeNg.filter(s -> s.matches("[A-Za-z0-9]{4}"))
          .orElseThrow(IllegalArgumentException::new); // ここで例外
      System.out.println("OK: " + ng);
    } catch (IllegalArgumentException e) {
      System.out.println("(例外発生: " + e.getClass().getSimpleName() + ")");
    }

    /*
      ==========================
      14問目: ifPresentOrElse で分岐メッセージ

      stock1、stock2 の値があれば "在庫あり(<n>)"、無ければ "在庫なし" と表示してください。

      ▼期待する出力結果
      在庫あり(3)
      在庫なし
      ==========================
    */
    System.out.println("\n【14問目】在庫メッセージ");
    Optional<Integer> stock1 = Optional.of(3);
    Optional<Integer> stock2 = Optional.empty();

    // 以下に回答コードを書いてください
    stock1.ifPresentOrElse(
        n -> System.out.println("在庫あり(" + n + ")"),
        () -> System.out.println("在庫なし")
    );

    stock2.ifPresentOrElse(
        n -> System.out.println("在庫あり(" + n + ")"),
        () -> System.out.println("在庫なし")
    );

    /*
      ==========================
      15問目: 応用（Optional + map + orElse）

      User のリストから、それぞれのユーザーの city を取得して表示してください。
      ・city が存在する場合は city 名をそのまま表示
      ・city が未設定の場合は "N/A" を表示
      ・Optional.map と orElse を使うこと

      ▼期待する出力結果
      Tokyo
      N/A
      Osaka
      ==========================
    */
    System.out.println("\n【15問目】応用（Optional + map + orElse）");
    List<User> users = List.of(
        new User("a1", new FullName("Taro", "Yamada"), Optional.of(20), Optional.empty(), Optional.of("Tokyo")),
        new User("a2", new FullName("Hanako", "Sato"), Optional.empty(), Optional.of("hanako@example.com"), Optional.empty()),
        new User("a3", new FullName("Jiro", "Tanaka"), Optional.of(30), Optional.empty(), Optional.of("Osaka"))
    );

    // 以下に回答コードを書いてください
    users.stream()
        .map(u -> u.city().orElse("N/A"))
        .forEach(System.out::println);
  }
}
