package task1;

/**
 * The {@code Main} class performs testing of classes functionality.
 */
public class Main {
    /**
     * Calls the test methods for testing the functionality of the {@link Hour} class.
     */
    public static void testingHour() {
        System.out.println("***************************************************************************");
        System.out.println("TESTING HOUR:");
        System.out.println("***************************************************************************");
        Hour hour = new Hour();
        hour.testHour();
        System.out.println("\n");
    }

    /**
     * Calls the test methods for testing the functionality of the {@link MetroStationWithArray} class.
     */
    public static void testingMetroStationWithArray(){
        System.out.println("***************************************************************************");
        System.out.println("TESTING METRO STATION WITH ARRAY:");
        System.out.println("***************************************************************************");
        MetroStationWithArray metroStation1 = new MetroStationWithArray();
        metroStation1.testMetroStationWithArray();
        System.out.println();
    }

    /**
     * Calls the test methods for testing the functionality of the {@link MetroStationWithSorting} class.
     */
    public static void testingMetroStationWithSorting() {
        System.out.println("***************************************************************************");
        System.out.println("TESTING METRO STATION WITH SORTING:");
        System.out.println("***************************************************************************");
        MetroStationWithSorting metroStation = new MetroStationWithSorting();
        metroStation.testMetroStationWithSorting();
        System.out.println();
    }

    /**
     * Calls the test methods which inherit from the abstract {@link AbstractMetroStation} class
     * for testing the functionality of the {@link MetroStationWithArray} class.
     */
    public static void testingMetroStationWithArrayWithSearchAndSort() {
        System.out.println("***************************************************************************");
        System.out.println("TESTING METRO STATION WITH ARRAY FOR SEARCHING AND SORTING:");
        System.out.println("***************************************************************************");
        MetroStationWithArray metroStation2 = new MetroStationWithArray();
        metroStation2.testSearchData();
        System.out.println("\n");
        metroStation2.testSortigData();
        System.out.println();
    }

    /**
     * Performs testing of classes functionality.
     * {@code args} are not used;
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        testingHour();
        testingMetroStationWithArray();
        testingMetroStationWithSorting();
        testingMetroStationWithArrayWithSearchAndSort();
    }
}
