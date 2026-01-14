package com.example.chapter05.practice01;

/**
 * 【問題01：Stringメソッド総復習 ― 名簿クリーナー（String）】
 * 名簿（文字列配列）には、全角スペースや不要な空白、大小混在、ハイフン区切りなどが含まれています。
 * 以下に記載の要件に従って、整形して出力してください。
 * <p>
 * ▼現在の出力結果（このプログラムをそのまま実行した場合）
 * 何も表示されない。
 * <p>
 * ▼期待される出力結果（正しく修正できた場合）
 * YAMADA TARO
 * SUZUKI HANAKO
 * SATO
 * TANAKA JIRO
 * [JP] JP
 * [JP] TEAM JP
 * <p>
 * ▼要件（【】内のメソッドを使う）
 * (1) 先頭・末尾の空白を除去する【trim】
 * (2) 間にある全角スペース（'\u3000'）やハイフン（'-'）を、半角スペース ' ' に統一する【replace】
 * (3) 連続する空白（半角スペース、タブ、改行などを含む）を「半角スペース1つ」に圧縮する【split + join】
 * ▼方法
 * - 文字列を空白で分割する。文字列の分割には、splitメソッド と 正規表現 "\\s+" を使う。
 * "\\s+" は、「空白（半角スペース、タブ、改行などを含む）が1文字以上の場合」にマッチする。
 * 例）String[] words = s.split("\\s+"); // これで "yamada   taro  san" が ["yamada", "taro", "san"] になる。
 * - 分割された文字列を指定の区切り文字で結合して、1つの文字列にする。文字列の結合にはjoinを使う。区切り文字には半角スペース1つを指定する。
 * 例）s = String.join(" ", words); // これで、 ["yamada", "taro", "san"] が "yamada taro san"になる
 * (4) すべて大文字化する【toUpperCase】
 * - 例）s = s.toUpperCase();
 * (5) 空白除去後の結果が "N/A" のみのときは出力しない【equals】
 * - 手順1～3でスペース除去した後、 if (s.equals("N/A")) { ... } で処理するとよい。
 * (6) 2文字未満の行は出力しない（2文字以上のみ出力）【length】
 * - 手順1～3でスペース除去した後、 if (s.length() >= 2) { ... } で処理するとよい。
 * (7) 文字列に "JP" を含む場合（大文字小文字は問わない）、先頭に "[JP] " を付ける【contains】
 * - 大文字小文字は、手順4で大文字化した後に contains("JP") を使えば判定可能
 * <p>
 * ※補足：String は不変（内部で持っているフィールドの値を変更できない）なので、replace / trim / toUpperCase の戻り値は必ず再代入する必要があります。
 */
public class Main {

    public static void main(String[] args) {
        String[] raw = {
                "  yamada   taro",      // 苗字と名前の間に半角スペースが複数入っている。名字の前に半角スペースが入っている。
                "sUzUkI\u3000hanako  ", // 苗字と名前の間に全角スペース（\u3000）が入っている。
                "  Sato  ",             // 名前の前後に半角スペースが複数入っている
                "",                     // 空文字
                " \u3000  ",            // 半角スペース + 全角スペース（\u3000） + 半角スぺース
                "  tanaka    jiro ",    // 苗字と名前の間や前後に半角スペースが複数入っている。
                " N/A ",                // N/Aが含まれている
                "  A  ",                // 文字数が2文字未満
                " jp ",                 // "JP" が含まれている
                " team-JP "             // '-'あり、かつ "JP" が含まれている
        };

        for (String line : raw) {
            // 文字列を整形する。
            String cleaned = clean(line);

            // (5) 空白除去後の結果が "N/A" のみのときは出力しない（equals）
            //参照型の比較はequals を使う！
            if (cleaned.equals("N/A")) { // 比較の仕方に誤りあり
                continue;
            }

            // (6) 2文字未満の行は出力しない（length）
            if (cleaned.length() >= 2) { // 条件式が誤りあり
                String label = "";

                // (7) 文字列に "JP" を含む場合（大文字小文字は問わない）、先頭に "[JP] " を付ける（contains）
                if (cleaned.contains("JP")) { // equalsだと "JP"を含むか ではなく "JP"と完全一致するか という意味になってしまう
                    label = "[JP] ";
                }
                System.out.println(label + cleaned);
            }
        }
    }

    /**
     * 1行の整形処理を行う。
     * - 先頭末尾の空白除去（trim）
     * - 全角スペースやハイフンの統一（replace）
     * - 空白の連続を半角スペース1つに圧縮（split + join）※ 正規表現 "\\s+" を使用する。
     * - すべて大文字化（toUpperCase）
     *
     * @param s 整形対象の文字列
     * @return 整形後の文字列
     */
    static String clean(String s) {
        // (1) 先頭末尾の空白を除去する（trim）
        s = s.trim();
        // (2) 全角スペース（\u3000） → 半角スペース  に置換する（replace）
        s = s.replace('\u3000', ' ');
        // (2) ハイフン '-' → 半角スペース ' ' に置換する（replace）

        // (3) 空白1回以上の連続を分割する（split）
        String[] words = s.split("\\s+"); // 誤り：これだと半角スペース1つで分割される→"\\s+"に修正済み

        // (3) 分割された文字列を半角スペース1つで結合して、1つの文字列にする。（join）
        s = String.join(" ", words);
        // (4) すべて大文字化する（toUpperCase）
        s = s.toUpperCase(); // 追加。アルファベットをすべて大文字化する。
        return s; // 整形した結果を返すようにする。
    }
}