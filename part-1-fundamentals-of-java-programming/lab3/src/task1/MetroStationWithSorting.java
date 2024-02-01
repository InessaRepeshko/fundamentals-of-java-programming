package task1;

import java.util.Arrays;

/**
 * Represents metro station data with an array of operating hours and overridden sorting methods.
 * This class extends (inherits from) the {@link MetroStationWithArray} class.
 * Also, this class is inherited from the abstract {@link AbstractMetroStation} class.
 */
public class MetroStationWithSorting extends MetroStationWithArray {
    /**
     * The constructor initialises the metro station with the default values.
     */
    public MetroStationWithSorting() {}

    /**
     * The constructor initialises the metro station with the specified values with {@code name} and {@code opened} year.
     * @param name  the name;
     * @param opened the opened year.
     */
    public MetroStationWithSorting(String name, int opened) {
        super(name, opened);
    }

    /**
     * The constructor initialises the metro station object with the specified values with {@code name},
     * {@code opened} year and  operating {@code hour}.
     * @param name  the name;
     * @param opened the opened year;
     * @param hours the array of hours.
     */
    public MetroStationWithSorting(String name, int opened, Hour[] hours) {
        super(name, opened, hours);
    }

    /**
     * Overridden decreasing ridership sorting method using the standard sort function of class {@code Arrays}.
     * This method is provided by the implementation of the Comparable interface for objects of type {@code Hour}.
     */
    @Override
    public void sortByDecreasingRidership() {
        if (getHours() == null) {
            return;
        }

        Arrays.sort(getHours());
    }

    /**
     * Overridden descending comment length sorting method using the standard sort function of class {@code Arrays}
     * and {@code Comparator}. This method is provided by creating a separate class {@code CommentComparator}
     * that implements the {@code Comparator} interface for objects of type {@code Hour}.
     */
    @Override
    public void sortByDescendingCommentLength() {
        if (getHours() == null) {
            return;
        }

        Arrays.sort(getHours(), new CommentComparator());
    }

    /**
     * Performs testing of the functionality of the {@code MetroStationWithSorting} class.
     */
    public void testMetroStationWithSorting() {
        System.out.println("Create Metro Station with default constructor:");
        MetroStationWithSorting metroStation = new MetroStationWithSorting();
        System.out.println(metroStation);

        System.out.println("Create Metro Station with parameterized constructor without Operating Hours:");
        MetroStationWithSorting metroStation1 = new MetroStationWithSorting("Kholodna Hora", 1975);
        System.out.println(metroStation1);

        System.out.println("Create Metro Station with parameterized constructor with 3 Operating Hours:");
        Hour[] hours1 = {
                new Hour(23, "Very low ridership"),
                new Hour(345, "Medium ridership"),
                new Hour(87, "Low ridership")
        };
        MetroStationWithSorting metroStation2 = new MetroStationWithSorting("Armiiska", 1978, hours1);
        System.out.println(metroStation2);
        metroStation2.testSortigData();
    }
}
