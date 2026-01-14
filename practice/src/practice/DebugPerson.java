package practice;

public class DebugPerson {
    String name;
    String hobby;

    public DebugPerson(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    public void introduceMyself() {
        System.out.println("I am" + name + ",My hobby is" + hobby);
    }
}
