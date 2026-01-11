public class ArrayPractice {
    public static void main(String[] args) {
        String[] names; // declare array
        names = new String[6];

        // assigning a reference, not the actual object
        names[0] = "Taro";
        names[1] = "Jiro";
        String[] namesInitialized = {"Taro", "Jiro", "Hanako"};
        System.out.println(namesInitialized[1]);

        //multidimensional array
        String[][] namesMultidimensional;
        namesMultidimensional = new String[3][2];

        // “assign values to each element of a multidimensional array”
        namesMultidimensional[0][0] = "Taro";
        String[][] names4 = {
                {"taro", "Jiro"},
                {"Saburo", "Jiro"}
        };

        String nameA = names[0];

        System.out.println(nameA);
        System.out.println("names2" + nameA);

        int names4Size = names4.length;
        System.out.println(names4Size);
    }
}
