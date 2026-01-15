package com.example.chapter06.practice01;

/**
 * チーズたこ焼きクラス。
 */
class CheeseTakoyaki extends Takoyaki {

    @Override
    int toppingFee() {
        return 100;
    }

    //@Override は「このメソッドは親クラス（またはインターフェース）のメソッドを上書きしている」という宣言です。付けておくと、
    // スペルミスやシグネチャ違い（引数や戻り値の違い）で実はオーバーライドできていない場合にコンパイルエラーで気付けます。
    //「1つだけ付けて残りは付けない」こともコンパイル自体は通る場合がありますが、意図の明示と事故防止の観点で、オーバーライドするものは全部付けるのが実務標準です。

    @Override
    String displayName() {
        return "チーズたこ焼き";
    }
}
