package task2;

public class EnumTest {
    private static void testSeason(Season season) {
        System.out.println("Current season:\n" + season);
        System.out.println("Previous season:\n" + season.previous());
        System.out.println("Next season:\n" + season.next() + "\n");
    }
    private static void testSeasons() {
        System.out.println("***************************************************************************");
        System.out.println("TEST SEASONS:");
        System.out.println("***************************************************************************");
        testSeason(Season.WINTER);
        testSeason(Season.SUMMER);
        Season.printAllSeasons();
    }

    private static void testMonth(Month month) {
        System.out.println("Current month:\n" + month);
        System.out.println("Previous month:\n" + month.previous());
        System.out.println("Next month:\n" + month.next() + "\n");
    }

    private static void testMonths() {
        System.out.println("\n***************************************************************************");
        System.out.println("TEST MONTHS:");
        System.out.println("***************************************************************************");
        testMonth(Month.FEBRUARY);
        testMonth(Month.DECEMBER);
        testMonth(Month.JANUARY);
        Month.printAllMonths();
    }

    public static void main(String[] args) {
        testSeasons();
        testMonths();
    }
}
