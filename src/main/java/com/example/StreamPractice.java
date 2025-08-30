package com.example;

import java.util.List;

public class StreamPractice {

  public static void main(String[] args) {


    // ==========================
    // 1問目: forEach の練習
    // 変数 names を使って、forEach で名前を1つずつ表示してください。
    // ==========================
    System.out.println("【1問目】forEach の練習");
    List<String> names = List.of("Alice", "Bob", "Charlie");

    // 以下に回答コードを書いてください


    // ==========================
    // 2問目: map の練習
    // 変数 numbers の各要素を2倍して表示してください。
    // ==========================
    System.out.println("\n【2問目】map の練習");
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    // 以下に回答コードを書いてください


    // ==========================
    // 3問目: filter の練習
    // 変数 words から、文字数が5文字以上の単語だけを取り出して表示してください。
    // ==========================
    System.out.println("\n【3問目】filter の練習");
    List<String> words = List.of("apple", "banana", "cherry", "date");

    // 以下に回答コードを書いてください


    // ==========================
    // 4問目: sorted の練習
    // 変数 nums を昇順にソートして表示してください。
    // ==========================
    System.out.println("\n【4問目】sorted の練習");
    List<Integer> nums = List.of(5, 1, 4, 2, 3);

    // 以下に回答コードを書いてください


    // ==========================
    // 5問目: distinct の練習
    // 変数 dupNumbers から重複を取り除いて表示してください。
    // ==========================
    System.out.println("\n【5問目】distinct の練習");
    List<Integer> dupNumbers = List.of(1, 2, 2, 3, 3, 3, 4);

    // 以下に回答コードを書いてください


    // ==========================
    // 6問目: collect の練習
    // 変数 items をカンマ区切りの1つの文字列 "apple,banana,cherry" に変換して表示してください。
    // ==========================
    System.out.println("\n【6問目】collect の練習");
    List<String> items = List.of("apple", "banana", "cherry");

    // 以下に回答コードを書いてください


    // ==========================
    // 7問目: reduce の練習
    // 変数 numbers2 の合計を reduce を使って計算してください。（結果: 15）
    // ==========================
    System.out.println("\n【7問目】reduce の練習");
    List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);

    // 以下に回答コードを書いてください


    // ==========================
    // 8問目: anyMatch の練習
    // 変数 animals に "cat" が含まれているかを判定して、true or falseを表示してください。
    // ==========================
    System.out.println("\n【8問目】anyMatch の練習");
    List<String> animals = List.of("dog", "cat", "bird");

    // 以下に回答コードを書いてください


    // ==========================
    // 9問目: allMatch の練習
    // 変数 evenNumbers の要素がすべて偶数かどうかを判定して、true or falseを表示してください。
    // ==========================
    System.out.println("\n【9問目】allMatch の練習");
    List<Integer> evenNumbers = List.of(2, 4, 6, 8);

    // 以下に回答コードを書いてください


    // ==========================
    // 10問目: max/min の練習
    // 変数 values から最大値と最小値を求めて表示してください。（結果: 最大値40, 最小値5）
    // ==========================
    System.out.println("\n【10問目】max/min の練習");
    List<Integer> values = List.of(10, 20, 5, 40, 15);

    // 以下に回答コードを書いてください


    // ==========================
    // 11問目: flatMap の練習
    // 変数 sentences には「文のリスト」が入っています。
    // 各文を「空白」で分けて、単語にしましょう。
    // すべての単語を1つのストリームにまとめて、
    // 単語を1つずつ改行して表示してください。
    //
    // 例: ["Java stream is powerful", "stream makes code concise"]
    // これを以下のように改行して表示する。
    // Java
    // stream
    // is
    // powerful
    // stream
    // makes
    // code
    // concise
    // ==========================
    System.out.println("\n【11問目】flatMap の練習");
    List<String> sentences = List.of(
        "Java stream is powerful",
        "stream makes code concise",
        "concise code is readable"
    );

    // 以下に回答コードを書いてください


    // ==========================
    // 12問目: groupingBy の練習
    // 変数 words2 には単語のリストがあります。
    // これらを「文字数ごと」にグループ分けしてください。
    // そして、各グループをまとめて表示してください。
    // 例: ["apple", "banana", "pear", "peach", "plum", "grape"]
    // 出力例（見やすい形でOKです）:
    // 3文字: [pear]
    // 4文字: [plum]
    // 5文字: [apple, peach, grape]
    // 6文字: [banana]
    // ==========================
    System.out.println("\n【12問目】groupingBy の練習");
    List<String> words2 = List.of("apple", "banana", "pear", "peach", "plum", "grape");

    // 以下に回答コードを書いてください


    // ==========================
    // 13問目: 複数メソッドチェーン練習（１）
    // 変数 names2 から4文字以上の名前を大文字に変換し、
    // 降順にソートして先頭3件を表示してください。
    // ==========================
    System.out.println("\n【13問目】チェーン練習①");
    List<String> names2 = List.of("alice", "bob", "christopher", "dave", "amelia", "brian", "charles");

    // 以下に回答コードを書いてください


    // ==========================
    // 14問目: 複数メソッドチェーン練習（２）
    // 変数 strNumbers から数値に変換できる文字列だけを取り出し、
    // 偶数だけに絞って合計を求めてください。
    // ==========================
    System.out.println("\n【14問目】チェーン練習②");
    List<String> strNumbers = List.of("10", "x", "21", "004", "seven", "18");

    // 以下に回答コードを書いてください


    // ==========================
    // 15問目: 複数メソッドチェーン練習（３）
    // 変数 csv には「都市名がカンマ区切り」で書かれた文字列が複数入っています。
    // これを処理して、次のようにしてください。
    // 1. 各行を「,（カンマ）」で分割して都市名に分ける
    // 2. 都市名の前後にある余計な空白を取り除く
    // 3. 5文字以上の都市名だけを残す
    // 4. 重複している都市名は1つにまとめる（distinct）
    // 5. アルファベット順（昇順）に並べ替える
    // 6. 1つずつ改行して 表示する
    //
    // 例: ["tokyo, osaka, nagoya", "osaka, fukuoka", "sapporo, tokyo"]
    // 出力結果:
    // fukuoka
    // nagoya
    // osaka
    // sapporo
    // tokyo
    // ==========================
    System.out.println("\n【15問目】チェーン練習③");
    List<String> csv = List.of(
        "tokyo, osaka, nagoya",
        "osaka, fukuoka",
        "sapporo, tokyo"
    );

    // 以下に回答コードを書いてください


    // ==========================
    // 16問目: 複数メソッドチェーン練習（４）
    // 変数 animals2 には動物の名前が入っています。
    // これを処理して、次のようにしてください。
    // 1. すべて小文字に変換する（例: "Cat" → "cat"）
    // 2. 名前の先頭文字ごとにグループ分けする（例: "cat","cow","camel" → "c" グループ）
    // 3. 各グループの要素数（件数）を数える
    // 4. 件数が多い順（降順）に並べ替える
    // 5. 「先頭文字: 件数」という形で1行ずつ表示する
    //
    // 例: ["Cat","cow","camel","dog","Deer","duck","ant","Ape"]
    // 出力結果（順序は件数の多い順）:
    // c: 3
    // d: 3
    // a: 2
    // （※ "Deer" → "deer", "Ape" → "ape" のように小文字化して処理）
    // ==========================
    System.out.println("\n【16問目】チェーン練習④");
    List<String> animals2 = List.of("Cat","cow","camel","dog","Deer","duck","ant","Ape");

    // 以下に回答コードを書いてください


    // ==========================
    // 17問目: 複数メソッドチェーン練習（５）
    // 変数 people の各 Person の平均点を計算し、
    // 平均80以上の人を降順に並べ、上位2名の名前を表示してください。
    // ==========================
    System.out.println("\n【17問目】チェーン練習⑤");
    record Person(String name, List<Integer> scores) {}
    List<Person> people = List.of(
        new Person("Alice",  List.of(80, 90, 75)),
        new Person("Bob",    List.of(70, 65)),
        new Person("Carol",  List.of(100, 95, 90)),
        new Person("Dave",   List.of(60))
    );

    // 以下に回答コードを書いてください


    // ==========================
    // 18問目: セール計算ゲーム（map → map → filter → リスト変数）
    // 変数 basePrices は商品価格（税抜）です。次の処理をしてください。
    // 1. それぞれの価格を 10% OFF にする（map）
    // 2. さらに送料として一律 200 円を加算する（map）
    // 3. 合計が 1,000 円以上の商品だけに絞り込む（filter）
    // 最終的に saleTotals という List<Integer> 型のリスト変数にして、その中身の値を表示してください。
    // ==========================
    System.out.println("\n【18問目】セール計算ゲーム");
    List<Integer> basePrices = List.of(980, 1200, 2500, 510, 3000);

    // 以下に回答コードを書いてください


    // ==========================
    // 19問目: SNSプロフィールURLメーカー（map → map → filter → リスト変数）
    // 変数 handles はユーザー名の一覧です。次の処理をしてください。
    // 1. すべて小文字に変換する（map）
    // 2. 前後の空白を取り除く（map）
    // 3. 半角英数字以外（空白・記号・括弧など）はすべて削除する（map）
    // 4. URLが20文字を超える場合は除外する（filter）
    // 5. 先頭に "https://example.com/u/" を付けてプロフィールURLにする（map）
    // 最終的に profileUrls という List<String> 型のリスト変数にして、その中身の値を表示してください。
    // ==========================
    System.out.println("\n【19問目】SNSプロフィールURLメーカー");
    List<String> handles = List.of("Alice", "bob_smith", "  CHARLIE 99  ", "D@ve!!", "super-long-handle-name");

    // 以下に回答コードを書いてください


    // ==========================
    // 20問目: 映画タイトルでハッシュタグ生成（map → map → filter → リスト変数）
    // 変数 movieTitles は映画タイトルです。次の処理をしてください。
    // 1. 前後の空白を取り除く（map）
    // 2. 単語の間のスペースを削除して1つの単語にまとめる（map）
    // 3. 先頭に '#' を付けてハッシュタグに変換する（map）
    // 4. ハッシュタグが 15 文字以内のものだけに絞り込む（filter）
    // 最終的に hashtags という List<String> 型のリスト変数にして、その中身の値を表示してください。
    // 例: "The Matrix" -> "#TheMatrix"
    // ==========================
    System.out.println("\n【20問目】映画タイトルでハッシュタグ生成");
    List<String> movieTitles = List.of("  The Matrix  ", "Spirited Away", "Interstellar", "A", "Lord of the Rings");

    // 以下に回答コードを書いてください


  }
}