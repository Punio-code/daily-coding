package stacktrace;

public class StackTraceDemo {
    public static void main(String[] args) {
        Person p = new Person("A", new Person("B", null));

        Debug.dumpHeapStats("before");
        Debug.dumpObjectGraph("person graph", p);
        Debug.dumpHeapStats("after");
    }

    static class Person {
        String name;
        Person friend;

        Person(String name, Person friend) {
            this.name = name;
            this.friend = friend;
        }
    }
}