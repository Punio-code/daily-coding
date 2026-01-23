package enumerate;

public enum Season {
    SPRING("a", 1),
    SUMMER("a", 2),
    FALL("a", 3),
    WINTER("a", 4);

//列挙型はあくまでｸﾗｽｲﾝｽﾀﾝｽである。引数付きの追加のﾌｨｰﾙﾄﾞを持たせるようなことをすると
    //各々の列挙型はそれに従わざるおえない

    private final String japanese;
    private final int startMonth;

    Season(String japanese, int startMonth) {
        this.japanese = japanese;
        this.startMonth = startMonth;
        System.out.println("このタイミングでコンストラクタが実行されます");
        System.out.println(this.japanese + this.startMonth);
    }
}

// name() 列挙子を文字列として返す
// values()  列挙子すべてを配列として返す
//　value of() 文字列から対応する列挙子を返す
