public class DebugMain {
    public static void main(String[] args) {

    }

    // DebugPerson型のインスタンスを生成して返すメソッド
    public DebugPerson createPerson(String name, String hobby) {
        DebugPerson debugPerson = new DebugPerson(hobby, name);
        return debugPerson;
    }
}
