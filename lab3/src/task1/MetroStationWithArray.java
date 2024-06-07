package task1;

/**
 * Represents metro station data with an array of operating hours.
 * This class is inherited from the abstract {@link AbstractMetroStation} class.
 */
public class MetroStationWithArray extends AbstractMetroStation {
    /** Name of the metro station. */
    private String name;

    /** Opened year of the metro station. */
    private int opened;

    /** Operating hours of the metro station. */
    private Hour[] hours;

    /**
     * The constructor initialises the metro station object with the default values.
     */
    public MetroStationWithArray() {}

    /**
     * The constructor initialises the metro station object with the specified values with {@code name}
     * and {@code opened} year.
     * @param name the name of metro station;
     * @param opened the opened year of metro station.
     */
    public MetroStationWithArray(String name, int opened) {
        this(name, opened, new Hour[0]);
    }

    /**
     * The constructor initialises the metro station object with the specified values with {@code name},
     * {@code opened} year and operating {@code hours}.
     * @param name  the name of metro station;
     * @param opened the opened year of metro station;
     * @param hours the array of operating hours of metro station.
     */
    public MetroStationWithArray(String name, int opened, Hour[] hours) {
        this.name = name;
        this.opened = opened;
        this.hours = hours;
    }

    /**
     * Gets the {@code name} for the metro station.
     * @return the {@code name} of metro station.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the {@code name} for the metro station.
     * @param name the {@code name} of metro station to be set.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the {@code opened} year for the metro station.
     * @return the {@code opened} year of metro station.
     */
    @Override
    public int getOpened() {
        return opened;
    }

    /**
     * Sets the {@code opened} year for the metro station.
     * @param opened the {@code opened} year of metro station to be set.
     */
    @Override
    public void setOpened(int opened) {
        this.opened = opened;
    }

    /**
     * Gets the array of operating hours for the metro station.
     * @return the array of hours.
     */
    @Override
    public Hour[] getHours() {
        return hours;
    }

    /**
     * Sets the array of operating hours for the metro station.
     * @param hours the array of hours to be set.
     */
    @Override
    public void setHours(Hour[] hours) {
        this.hours = hours;
    }

    /**
     * Gets the {@code hour} with index {@code i} from the hours array.
     * @return the object of class {@code Hour} with index {@code i}.
     */
    @Override
    public Hour getHour(int i) {
        if (getHours() == null
                || getHours().length == 0
                || i < 0
                || i >= getHours().length) {
            return null;
        }

        return getHours()[i];
    }

    /**
     * Sets the {@code hour} with index {@code i} to hours array.
     * @param i index of {@code hour} in hours array;
     * @param hour the object of class {@code Hour} with index {@code i} to be set.
     */
    @Override
    public void setHour(int i, Hour hour) {
        if (getHours() == null
                || getHours().length == 0
                || i < 0
                || i >= getHours().length) {
            return;
        }

        getHours()[i] = hour;
    }

    /**
     * Adds a link to the new {@code hour} at the end of the hours array.
     * @param hour the object of class {@code Hour} to be added to the hours array;
     * @return {@code true}, if the link was added successfully, {@code false} otherwise.
     */
    @Override
    public boolean addHour(Hour hour) {
        if (getHours() != null) {
            if (hour.getRidership() < 0
                    || hour.getComment() == null) {
                return false;
            }

            for (Hour h : getHours()) {
                if (h.equals(hour)) {
                    return false;
                }
            }
        }

        setHours(addHourToArray(getHours(), hour));

        return true;
    }

    /**
     * Creates a new {@code hour} and adds a link to it at the end of the sequence at the hours array.
     * @param ridership the ridership;
     * @param comment the comment;
     * @return {@code true}, if the link was added successfully, {@code false} otherwise.
     */
    @Override
    public boolean addHour(int ridership, String comment) {
        if (ridership < 0
                || comment == null) {
            return false;
        }

        Hour newHour = new Hour(ridership, comment);

        return addHour(newHour);
    }

    /**
     * Counts the number of hours in the sequence at hours array.
     * @return the number of hours.
     */
    @Override
    public int countHours() {
        if (getHours() == null) {
            return 0;
        }

        return getHours().length;
    }

    /**
     * Removes the sequence of hours from hours array.
     */
    @Override
    public void removeHours() {
        setHours(null);
    }

    /**
     * Performs testing of the functionality of the {@code MetroStationWithArray} class.
     */
    public void testMetroStationWithArray() {
        System.out.println("Create Metro Station with default constructor:");
        MetroStationWithArray metroStation = new MetroStationWithArray();
        System.out.println(metroStation);

        System.out.println("Create Metro Station with parameterized constructor without Operating Hours:");
        MetroStationWithArray metroStation1 = new MetroStationWithArray("Sportyvna", 1975);
        System.out.print(metroStation1);

        System.out.println("Create Metro Station with parameterized constructor with 3 Operating Hours:");
        Hour[] hours1 = {
                new Hour(23, "Very low ridership"),
                new Hour(345, "Medium ridership"),
                new Hour(87, "Low ridership")
        };
        MetroStationWithArray metroStation2 = new MetroStationWithArray("Oleksiivska", 2010, hours1);
        System.out.println(metroStation2);

        System.out.println("Reset all Operating Hours for \'" + metroStation2.getName() + "\' Metro Station:");
        Hour[] hours2 = {
                new Hour(256, "Medium ridership"),
                new Hour(817, "High ridership"),
                new Hour(1115, "Very high ridership")
        };
        metroStation2.setHours(hours2);
        System.out.println(metroStation2);

        System.out.println("Set new Operating Hour at index 0 for Metro Station \'" + metroStation2.getName() + "\':");
        metroStation2.setHour(0, new Hour(88, "Very low ridership"));
        System.out.println("Operating Hours for Metro Station \'" + metroStation2.getName() + "\':");
        for (Hour h : metroStation2.getHours()) {
            System.out.println(h);
        }
        System.out.println();

        int index = 1;
        System.out.println("Get Operating Hour for Metro Station \'" + metroStation2.getName()
                + "\' at index " + index + ":");
        System.out.println(metroStation2.getHour(index));
        System.out.println();

        System.out.println("Count Operating Hours of Metro Station \'" + metroStation2.getName() + "\':\t"
                + metroStation2.countHours());
        System.out.println();

        System.out.println("Get info about Metro Station 1:\t" + "Name:\t\'" + metroStation1.getName()  + "\'\tOpened:\t"
                + metroStation1.getOpened());
        System.out.println("Get info about Metro Station 2:\t" + "Name:\t\'" + metroStation2.getName()  + "\'\tOpened:\t"
                + metroStation2.getOpened());
        System.out.println();

        System.out.println("Check for equal Metro Station 1 and 2:\t" + metroStation1.equals(metroStation2));
        System.out.println("Hashcode of Metro Station 1:\t" + metroStation1.hashCode());
        System.out.println("Hashcode of Metro Station 2:\t" + metroStation2.hashCode());
        System.out.println();

        System.out.println("Duplicate all the data of Metro Station 2 into Metro Station 1.");
        metroStation1.setName(metroStation2.getName());
        metroStation1.setOpened(metroStation2.getOpened());
        metroStation1.setHours(metroStation2.getHours());
        System.out.println("Check for equal Metro Station 1 and 2 when its data are identical:\t"
                + metroStation1.equals(metroStation2));
        System.out.println("Hashcode of Metro Station 1:\t" + metroStation1.hashCode());
        System.out.println(metroStation1);
        System.out.println("Hashcode of Metro Station 2:\t" + metroStation2.hashCode());
        System.out.println(metroStation2);
    }
}
