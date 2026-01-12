public class TestOverload {


    private String message;

    // ｺﾝｽﾄﾗｸﾀにおいてもｵｰﾊﾞｰﾛｰﾄﾞはせいりつ
    public TestOverload() {
        this.message = "default";
    }

    public TestOverload(String message
    ) {
        this.message = "default";
    }

    public void testoverload() {
        System.out.print("overload1");
    }

    public void testoverload(String message) {
        System.out.print("overload2");
    }

    public void testoverload(String message, int count) {
        System.out.print("overload3");
    }

    //引数の型が異なってもOverloadは成立する
    public void displayTestOverload(int num) {
        System.out.println(num);
    }

    public void displayTestOverload(double num) {
        System.out.println(num);
    }

    //引数の型がおなじでも定義順序が違うならOverloadは成立する
    public void showTestOverload(String text, int num) {
        System.out.println(num + text);
    }

    public void showTestOverload(double num, String text) {
        System.out.println(num + text);
    }

    //戻り値の型だけが異なる場合はｵｰﾊﾞｰﾛｰﾄﾞが成立しないため、定義不可能ｺﾝﾊﾟｲﾙｴﾗｰになる
}
