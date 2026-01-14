package practice;

public class DebugMain {

    // DebugPerson型のインスタンスを生成して返すメソッド
    public static DebugPerson createPerson(String name, String hobby) {
        DebugPerson debugPerson = new DebugPerson(name, hobby);
        //throw new RuntimeException("なんとなく");
        return debugPerson;
    }

    public static void main(String[] args) {
        DebugPerson debugPerson = createPerson("Taro", "soccer");

        debugPerson.introduceMyself();

    }
}
