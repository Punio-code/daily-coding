public class LocalVariableExample {
    public static void main(String[] args) {
        int x = 5;
        if (true) {
            //int x = 5;
            //ここでxを宣言するとﾌﾞﾛｯｸ外で参照をするとnull pointer exception となる スコ―プはこのブロック内だけ
            System.out.println(x);
        }
        int num;
        //int型のｸﾗｽ変数や、インスタンス変数は初期値は自動でint0であるのが仕様であるが、ﾛｰｶﾙ変数は未定義となりここでnumに何か代入しなければｺﾝﾊﾟｲﾙｴﾗｰを吐く
        // System.out.println(num);

        char text = '\u0041';
        //A これがﾌｨｰﾙﾄﾞ変数であればDefault値はNULL 文字になる
        System.out.println(text);

        String name = null;
    }
}
