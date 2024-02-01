package task4.helpers;

public class TypeCaster {
    public static boolean cast(int value) {
        return value != 0;
    }

    public static int cast(boolean value) {
        return value ? 1 : 0;
    }
}

