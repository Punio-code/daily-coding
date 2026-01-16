package com.example.chapter07.practice02;

/**
 * 【問題02：おこづかいの金額表示を完成させよう（インターフェース／実装の差し替え）】
 * このプログラムは、PriceFormatter インターフェースの実装を差し替えて
 * 同じ金額を別々の表記で表示する練習です。
 * いまは実装クラスが存在しないためコンパイルエラーになります。
 * 下の「▼指示」にしたがって実装クラスを作成し、期待される出力になるように完成させてください。
 * <p>
 * ▼現在の出力（このまま実行した場合）
 * ※ 実装クラスが無いため、コンパイルエラーになります。
 * <p>
 * ▼期待される出力（正しく実装できた場合の例）
 * 金額: 980
 * - 円で表示: 980円
 * - ¥で表示: ¥980
 * - 税込10%で表示: 1,078円
 * 金額: 1234
 * - 円で表示: 1,234円
 * - ¥で表示: ¥1,234
 * - 税込10%で表示: 1,357円
 * <p>
 * ▼指示
 * ・PriceFormatter を実装した次の3クラスを、同じパッケージに新規作成してください。
 * (1) YenSuffixFormatter
 * - 出力例: "1,234円"（3桁区切り＋末尾に「円」）
 * (2) YenSymbolFormatter
 * - 出力例: "¥1,234"（3桁区切り＋先頭に「¥」、末尾の「円」は付けない）
 * (3) TaxIncludedFormatter
 * - 税抜金額 + 税込10%（税抜×1.1）を、小数点以下を四捨五入して整数化してから、
 * YenSuffixFormatter と同じ形式（3桁区切り＋末尾に「円」）で表示する
 * 例: 1234 → 1234×1.1=1357.4 → 1357 → "1,357円"
 * ・3クラスの format(int yen) には必ず @Override を付けてください。
 * ・Main のコードは変更せず、3クラスの実装だけで期待出力になることを目指してください。
 * <p>
 * ▼ヒント
 * ・3桁区切りされた金額（文字列）は、 String.format(Locale.JAPAN, "%,d", 金額) で取得できます。
 * ・四捨五入は Math.round(値) を使えます（戻り値は long。(int)Math.round(yen * 1.1) など）。
 * ・円記号は半角の '¥' を使いましょう。
 */
public class Main {
    public static void main(String[] args) {
        // 金額 980 の出力
        printAllFormats(980);

        // 金額 1234 の出力
        printAllFormats(1234);
    }

    /**
     * 金額を受け取り、3種類のフォーマッタで表示する。
     *
     * @param amount 金額
     */
    private static void printAllFormats(int amount) {
        System.out.println("金額: " + amount);

        PriceFormatter formatter;

        // (1) 円で表示（末尾に「円」）
        formatter = new YenSuffixFormatter(); // ←実装クラスを作成してコンパイルエラーを解消してください。
        System.out.println(" - 円で表示: " + formatter.format(amount));

        // (2) ¥で表示（先頭に「¥」）
        formatter = new YenSymbolFormatter(); // ←実装クラスを作成してコンパイルエラーを解消してください。
        System.out.println(" - \uFFE5で表示: " + formatter.format(amount));

    // (3) 税込10%で表示（税込10%分を加えて四捨五入後、末尾に「円」）
    formatter = new TaxIncludedFormatter(); // ←実装クラスを作成してコンパイルエラーを解消してください。
    System.out.println(" - 税込10%で表示: " + formatter.format(amount));
//  }
    }
}