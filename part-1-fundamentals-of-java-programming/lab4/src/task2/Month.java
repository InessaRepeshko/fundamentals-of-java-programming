package task2;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private final int daysPerMonth;

    Month(int daysPerMonth) {
        this.daysPerMonth = daysPerMonth;
    }

    public int getDaysPerMonth() {
        return daysPerMonth;
    }

    public String getMonthNameUA() {
        return switch (this) {
            case JANUARY -> "Січень";
            case FEBRUARY -> "Лютий";
            case MARCH -> "Березень";
            case APRIL -> "Квітень";
            case MAY -> "Травень";
            case JUNE -> "Червень";
            case JULY -> "Липень";
            case AUGUST -> "Серпень";
            case SEPTEMBER -> "Вересень";
            case OCTOBER -> "Жовтень";
            case NOVEMBER -> "Листопад";
            case DECEMBER -> "Грудень";
            default -> "Невідомо";
        };
    }

    Month next() {
        return (values())[(ordinal() + 1) % values().length];
    }

    Month previous() {
        return (values())[(ordinal() + 11) % values().length];
    }

    public Season getSeason() {
        return switch (this) {
            case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
            case MARCH, APRIL, MAY -> Season.SPRING;
            case JUNE, JULY, AUGUST -> Season.SUMMER;
            case SEPTEMBER, OCTOBER, NOVEMBER -> Season.AUTUMN;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "\tThe month of\t\'" + getMonthNameUA() + "\' \thas  " + getDaysPerMonth()
                + " days and ordinal number  " + ordinal()
                + ".\n\tSeason of the month:" + getSeason();
    }

    public static void printAllMonths() {
        System.out.println("All months:");

        for (Month m : values()) {
            System.out.println(m);
        }

        System.out.println();
    }
}
