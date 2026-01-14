package stacktrace;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        Decimal alpha = new Decimal(a);
        Person p = new Person("A", new Person("B", null));

        Debug.dumpHeapStats("before");
        Debug.dumpObjectGraph("person graph", p);
        Debug.dumpHeapStats("after");
        System.out.println(alpha.decimalPlus());
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