package task2;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    public String getSeasonNameUA() {
        return switch (this) {
            case WINTER -> "Зима";
            case SPRING -> "Весна";
            case SUMMER -> "Літо";
            case AUTUMN -> "Осінь";
            default -> "Невідомо";
        };
    }

    Season next() {
        return (values())[(ordinal() + 1) % values().length];
    }

    Season previous() {
        return (values())[(ordinal() + 3) % values().length];
    }

    @Override
    public String toString() {
        return "\tThe season\t\'" + getSeasonNameUA() + "\'\thas ordinal number  " + ordinal() + ".";
    }

    public static void printAllSeasons() {
        System.out.println("All seasons:");

        for (Season s : values()) {
            System.out.println(s);
        }

        System.out.println();
    }
}
