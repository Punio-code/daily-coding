package poly;


public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.cry();
        //Animalに定義されていないﾒｿｯﾄﾞは使用できない
        //親クラスという『型』の箱に入れている限り、親クラスにないことは（外からは）させてもらえない
        //dog.ote();

        if (dog instanceof Dog) {
            System.out.println("TheDogInstance");
        } else {
            System.out.println("NotDogInstance");
        }

        Animal[] animals = {
                dog, cat
        };

        for (Animal animal : animals) {
            animal.cry();
        }
    }

}


