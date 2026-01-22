package com.example.chapter10;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    /*
      ==========================
      1問目: forEach の練習
      変数 names を使って、forEach で名前を1つずつ表示してください。

      ▼出力結果
      Alice
      Bob
      Charlie
      ==========================
    */
        System.out.println("【1問目】forEach の練習");
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // 以下に回答コードを書いてください
        names.forEach(System.out::println);

    /*
      ==========================
      2問目: map の練習
      変数 numbers の各要素を2倍して表示してください。

      ▼出力結果
      2
      4
      6
      8
      10
      ==========================
    */
        System.out.println("\n【2問目】map の練習");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // 以下に回答コードを書いてください
        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

    /*
      ==========================
      3問目: filter の練習
      変数 words から、文字数が5文字以上の単語だけを取り出して表示してください。

      ▼出力結果
      apple
      banana
      cherry
      ==========================
    */
        System.out.println("\n【3問目】filter の練習");
        List<String> words = List.of("apple", "banana", "cherry", "date");

        // 以下に回答コードを書いてください
        words.stream()
                .filter(word -> word.length() >= 5)
                .forEach(System.out::println);

    /*
      ==========================
      4問目: sorted の練習
      変数 nums を昇順にソートして表示してください。

      ▼出力結果
      1
      2
      3
      4
      5
      ==========================
    */
        System.out.println("\n【4問目】sorted の練習");
        List<Integer> nums = List.of(5, 1, 4, 2, 3);

        // 以下に回答コードを書いてください
        nums.stream()
                //小さい順に並べて表示する
                .sorted()
                .forEach(System.out::println);

    /*
      ==========================
      5問目: distinct の練習
      変数 dupNumbers から重複を取り除いて表示してください。

      ▼出力結果
      1
      2
      3
      4
      ==========================
    */
        System.out.println("\n【5問目】distinct の練習");
        List<Integer> dupNumbers = List.of(1, 2, 2, 3, 3, 3, 4);

        // 以下に回答コードを書いてください
        dupNumbers.stream()
                .distinct()
                .forEach(System.out::println);

    /*
      ==========================
      6問目: collect の練習
      collectを使って、languages から Map<String, Integer>（キー: 言語名、値: 文字数）を作って表示してください。

      ▼出力例（順不同）
      {java=4, python=6, php=3}
      ==========================
    */
        System.out.println("\n【6問目】collect の練習");
        List<String> languages = List.of("java", "python", "php");

        // 以下に回答コードを書いてください
        //Map型　Stringのデータを受け取り、Integerを返す。　その変数の箱はresult 　入力元のStringのデータ（laguagesの個々の要素)に連続処理（stream)を施します
        Map<String, Integer> result = languages.stream()
                //その連続処理のフローは*Stream の要素列を「別の形（データ構造や集計結果）」に畳み込む（＝終端操作）*から始まります、その入力、つまりストリームの各要素を (キー, 値) に変換して Map に put していく Collector を生成
                .collect(Collectors.toMap(
                        x -> x,
                        String::length
                ));
        //.collectはMap は「キー → 値（value）」の対応（エントリ）の集合　を作るﾒｿｯﾄﾞです。
        System.out.println(result);
    /*
      ==========================
      7問目: reduce の練習
      変数 numbers2 のすべての要素の合計を reduce を使って計算してください。
      ▼出力結果
      15
      ==========================
    */
        System.out.println("\n【7問目】reduce の練習");
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);

        // 以下に回答コードを書いてください
        int sum = numbers2.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    /*
      ==========================
      8問目: anyMatch の練習
      変数 animals に "cat" が含まれているかを判定して表示してください。

      ▼出力結果
      true
      ==========================
    */
        System.out.println("\n【8問目】anyMatch の練習");
        List<String> animals = List.of("dog", "cat", "bird");

        // 以下に回答コードを書いてください
        boolean hasCat = animals.stream()
                .anyMatch("cat"::equals);
        //終端操作は Stream以外を返す、または void　つまりbooleanを返すと終端操作としてﾊﾟｲﾌﾟﾗｲﾝは確定終了する　terminal operation　
        System.out.println(hasCat);
    /*
      ==========================
      9問目: allMatch の練習
      変数 evenNumbers の要素がすべて偶数かどうかを判定して表示してください。
      ▼出力結果
      true
      ==========================
    */
        System.out.println("\n【9問目】allMatch の練習");
        List<Integer> evenNumbers = List.of(2, 4, 6, 8);

        // 以下に回答コードを書いてください
        boolean allEven = evenNumbers.stream()
                // 入力に対し　2で割ったときの余りが０（つまり偶数である　を判定　した値をかえす
                .allMatch(n -> n % 2 == 0);
        System.out.println(allEven);
    /*
      ==========================
      10問目: max/min の練習
      変数 values から最大値と最小値を求めて表示してください。

      ▼出力結果
      最大値40, 最小値5
      ==========================
    */
        System.out.println("\n【10問目】max/min の練習");
        List<Integer> values = List.of(10, 20, 5, 40, 15);

        // 以下に回答コードを書いてください
        IntSummaryStatistics stats = values.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println(STR."最大値\{stats.getMax()}, 最小値\{stats.getMin()}");
    /*
      ==========================
      11問目: flatMap の練習
      変数 sentences（文のリスト）を単語に分解し、1単語ずつ改行して表示してください。

      ▼出力結果
      Java
      stream
      is
      powerful
      stream
      makes
      code
      concise
      concise
      code
      is
      readable
      ==========================
    */
        System.out.println("\n【11問目】flatMap の練習");
        List<String> sentences = List.of(
                "Java stream is powerful",
                "stream makes code concise",
                "concise code is readable"
        );

        // 以下に回答コードを書いてください
        sentences.stream()
                .flatMap(s -> Arrays.stream(s.trim().split("\\s+")))
                .forEach(System.out::println);

    /*
      ==========================
      12問目: groupingBy の練習
      変数 words2 を「文字数ごと」にグループ分けして表示してください。

      ▼出力例（順不同）
      4文字: [pear, plum]
      5文字: [apple, peach, grape]
      6文字: [banana]
      ==========================
    */
        System.out.println("\n【12問目】groupingBy の練習");
        List<String> words2 = List.of("apple", "banana", "pear", "peach", "plum", "grape");

        // 以下に回答コードを書いてください
        Map<Integer, List<String>> grouped = words2.stream()
                //配列を作るのでcollect groupingBy(String型のlengthに従って）
                .collect(Collectors.groupingBy(String::length//何をキーにして分けるか
                        , TreeMap::new,//どのMapに詰めるか（HashMapかTreeMapか等）
                        Collectors.toList()));//分けた後の値をどう加工・集計するか
        grouped.forEach((length, ws) -> System.out.println(STR."\{length}文字:\{ws}"));
    /*
      ==========================
      13問目: 複数メソッドチェーン練習（１）
      変数 names2 から「4文字以上」の名前を大文字にし、降順にソートして先頭3件を表示してください。

      ▼出力結果
      DAVE
      CHRISTOPHER
      CHARLES
      ==========================
    */
        System.out.println("\n【13問目】チェーン練習（１）");
        List<String> names2 = List.of("alice", "bob", "christopher", "dave", "amelia", "brian",
                "charles");

        // 以下に回答コードを書いてください
        names2.stream()
                .filter(n -> n.length() >= 4)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    /*
      ==========================
      14問目: 複数メソッドチェーン練習（２）
      文字列のうち数値だけを整数に変換し、偶数のみ合計して表示してください。

      ▼出力結果
      32
      ==========================
    */
        System.out.println("\n【14問目】チェーン練習（２）");
        List<String> strNumbers = List.of("10", "x", "21", "004", "seven", "18");

        // 以下に回答コードを書いてください
        int sumStrNumbers = strNumbers.stream()
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .filter(s -> s % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sumStrNumbers);
    /*
      ==========================
      15問目: 複数メソッドチェーン練習（３）
      変数 csv には「都市名がカンマ区切り」で書かれた文字列が複数入っています。
      これを処理して、次のようにしてください。
      1. 各行を「,（カンマ）」で分割して都市名に分ける
      2. 都市名の前後にある余計な空白を取り除く
      3. 5文字以上の都市名だけを残す
      4. 重複している都市名は1つにまとめる（distinct）
      5. アルファベット順（昇順）に並べ替える
      6. 1つずつ改行して 表示する

      ▼出力結果
      fukuoka
      nagoya
      osaka
      sapporo
      tokyo
      ==========================
    */
        System.out.println("\n【15問目】チェーン練習（３）");
        List<String> csv = List.of(
                "tokyo, osaka, nagoya",
                "osaka, fukuoka",
                "sapporo, tokyo"
        );// 以下に回答コードを書いてください
        csv.stream()
                .flatMap(a -> Arrays.stream(a.split(",")))
                .map(String::trim)
                .filter(name -> name.length() >= 5)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    /*
      ==========================
      16問目: 複数メソッドチェーン練習（４）
      変数 animals2 には動物の名前が入っています。
      これを処理して、次のようにしてください。
      1. すべて小文字に変換する（例: "Cat" → "cat"）
      2. 名前の先頭文字ごとにグループ分けする（例: "cat","cow","camel" → "c" グループ）
      3. 各グループの要素数（件数）を数える
      4. 件数が多い順（降順）に並べ替える
      5. 「先頭文字: 件数」という形で1行ずつ表示する

      ▼出力結果
      c: 3
      d: 3
      a: 2
      ==========================
    */
        System.out.println("\n【16問目】チェーン練習（４）");
        List<String> animals2 = List.of("Cat", "cow", "camel", "dog", "Deer", "duck", "ant", "Ape");

        // 以下に回答コードを書いてください
        animals2.stream()
                //map の役割：T -> R の変換を 各要素に一様に適用して、Stream<R> を作る（中間操作）
                .map(String::toLowerCase)
                //collect は、正確には Stream の要素を“集約（collect）して”、指定した形の結果コンテナ（または集計値）に作り替える終端操作です。
                .collect(Collectors.groupingBy(s -> s.charAt(0),
                        Collectors.counting()))
                //「順番のない対応表を、操作可能な単位（ペア）として扱えるようにする」
                .entrySet().stream()
                //Comparator は「順序（ordering）」という意味論を定義するだけで、並べ替えという実行はしません。
                .sorted(Comparator.comparing(Map.Entry<Character, Long>::getValue).reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));



    /*
      ==========================
      17問目: 複数メソッドチェーン練習（５）
      各 Person の平均点を求め、平均80以上の人を降順に並べて
      上位2名の名前を表示してください。

      ▼出力結果
      Carol
      Alice
      ==========================
    */
        System.out.println("\n【17問目】チェーン練習（５）");
        record Person(String name, List<Integer> scores) {

        }
        List<Person> people = List.of(
                new Person("Alice", List.of(80, 90, 75)),
                new Person("Bob", List.of(70, 65)),
                new Person("Carol", List.of(100, 95, 90)),
                new Person("Dave", List.of(60))
        );

        // 以下に回答コードを書いてください

        people.stream()
                //public java.util.stream.Stream<E>
                //真偽値を抽出　average()はoptionalDouble型なのでここで終われない
                //並び替え
                //任意の2つの値（k, v）を、後段で getKey()/getValue() として扱える“ペア”にする
                .map(p -> Map.entry(
                        p.name(),
                        p.scores().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    /*
      ==========================
      18問目: セール計算ゲーム（map → map → filter → リスト変数）
      変数 basePrices は商品価格（税抜）です。次の処理をしてください。
      1. それぞれの価格を 10% OFF にする（map）
      2. さらに送料として一律 200 円を加算する（map）
      3. 合計が 1,000 円以上の商品だけに絞り込む（filter）
      最終的に saleTotals という List<Integer> 型のリスト変数にして、その中身の値を表示してください。

      ▼出力結果
      [1082, 1280, 2450, 2900]
      ==========================
    */
        System.out.println("\n【18問目】セール計算ゲーム");
        List<Integer> basePrices = List.of(980, 1200, 2500, 510, 3000);

        // 以下に回答コードを書いてください
        List<Integer> saleTotal = basePrices.stream()
                .map(k -> (int) (k * 0.9))
                .map(v -> v + 200)
                .filter(e -> e >= 1000)
                .collect(Collectors.toList());
        System.out.println(saleTotal);
    /*
      ==========================
      19問目: SNSプロフィールURLメーカー（map → map → filter → リスト変数）
      変数 handles はユーザー名の一覧です。次の処理をしてください。
      1. すべて小文字に変換する（map）
      2. 前後の空白を取り除く（map）
      3. 半角英数字以外（空白・記号・括弧など）はすべて削除する（map）
      4. URLが20文字を超える場合は除外する（filter）
      5. 先頭に "https://example.com/u/" を付けてプロフィールURLにする（map）
      最終的に profileUrls という List<String> 型のリスト変数にして、その中身の値を表示してください。

      ▼出力結果
      [https://example.com/u/alice, https://example.com/u/bobsmith, https://example.com/u/charlie99, https://example.com/u/dve, https://example.com/u/superlonghandlename]
      ==========================
    */
        System.out.println("\n【19問目】SNSプロフィールURLメーカー");
        List<String> handles = List.of("Alice", "bob_smith", "  CHARLIE 99  ", "D@ve!!",
                "super-long-handle-name");

        // 以下に回答コードを書いてください
        List<String> profileUrls =
                handles.stream().map(e -> e.toLowerCase())
                        .map(e -> e.trim().replaceAll("[^A-Za-z0-9]", ""))
                        .filter(e -> e.length() <= 20)
                        .map(e -> "https://example.com/u/" + e)
                        .toList();

        System.out.println(profileUrls);
    /*
      ==========================
      20問目: 映画タイトルでハッシュタグ生成（map → map → filter → リスト変数）
      変数 movieTitles は映画タイトルです。次の処理をしてください。
      1. 前後の空白を取り除く（map）
      2. 単語の間のスペースを削除して1つの単語にまとめる（map）
      3. 先頭に '#' を付けてハッシュタグに変換する（map）
      4. ハッシュタグが 15 文字以内のものだけに絞り込む（filter）
      最終的に hashtags という List<String> 型のリスト変数にして、その中身の値を表示してください。

      ▼出力結果
      [#TheMatrix, #SpiritedAway, #Interstellar, #A, #LordoftheRings]
      ==========================
    */
        System.out.println("\n【20問目】映画タイトルでハッシュタグ生成");
        List<String> movieTitles = List.of("  The Matrix  ", "Spirited Away", "Interstellar", "A",
                "Lord of the Rings");

        // 以下に回答コードを書いてください
        List<String> hashtags = movieTitles.stream()
                .map(String::trim)
                .map(e -> e.replaceAll("\\s+", ""))
                .map(e -> "#" + e)
                .filter(v -> v.length() <= 15)
                .collect(Collectors.toList());
        System.out.println(hashtags);
    }
}