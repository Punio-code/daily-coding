package enumerate;

public class Main {
    static void main(String[] args) {
        Season season = Season.SUMMER;

        if (season == season.SUMMER) {
            System.out.println("Natu");
        } else {
            System.out.println("Not Natu");
        }

        System.out.println(season.name());

        Season[] seasons = Season.values();
        for (Season s : seasons) {
            System.out.println(s.name());
        }

        Season season2 = Season.valueOf("SPRING");
        System.out.println(season2.name());

    }
}
