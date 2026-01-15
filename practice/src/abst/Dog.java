package abst;

public class Dog extends Animal {
    @Override
    public void greet(String name) {
        System.out.println(name + "hello");
    }
}
