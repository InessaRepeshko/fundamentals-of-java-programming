package task3;

public class ArrayOperations {
    private ArrayOperations() {}

    private static <T> void swapElementsByIndex(T[] array, int srcIndex, int dstIndex) {
        T temp = array[srcIndex];
        array[srcIndex] = array[dstIndex];
        array[dstIndex] = temp;
    }

    public static <T> boolean swapGroupsOfElements(int srcBegin, int srcEnd, T[] array, int dstBegin) {
        if (srcBegin < 0
                || dstBegin < 0
                || srcEnd <= 0
                || array.length < srcBegin + srcEnd
                || array.length < dstBegin + srcEnd
                || srcBegin == dstBegin) {
            return false;
        }

        for (int i = 0; i < srcEnd; i++) {
            swapElementsByIndex(array, srcBegin + i, dstBegin + i);
        }

        return true;
    }

    public static <T> boolean swapAdjacentElements(T[] array) {
        if (array.length <= 1) {
            return false;
        }

        for (int i = 0; i < array.length - 1; i += 2) {
            swapElementsByIndex(array, i, i + 1);
        }

        return true;
    }

        public static <T> boolean replaceGroupOfElements(T[] src, int srcBegin, T[] dst, int dstBegin, int dstEnd) {
        if (dstBegin < 0
                || srcBegin < 0
                || dstEnd <= 0
                || dst.length < dstBegin + dstEnd
                || src.length < srcBegin + dstEnd) {
            return false;
        }

        for (int i = 0; i < dstEnd; i++) {
            dst[dstBegin + i] = src[srcBegin + i];
        }

        return true;
    }
}
