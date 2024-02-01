package task7;

/**
 * The {@link OneDimBoundedArrayTest} class that contains test scenarios for the {@link OneDimBoundedArray} class.
 */
public class OneDimBoundedArrayTest {
    /**
     * Tests the {@link OneDimBoundedArray} class functionality with the given array and element value.
     * @param <T> the type of elements stored in the array;
     * @param array The OneDimBoundedArray instance to test.
     * @param elementValue The element value to use in the tests.
     */
    private static <T> void testArray(OneDimBoundedArray<T> array, T elementValue) {
        System.out.println("Initial array of Integers with indexes" + array + "\n");

        int index = 10;
        System.out.print("Get an array element at index " + index + ": \t");
        System.out.println(array.get(index));
        index = -10;
        System.out.print("Get an array element at index " + index + ": \t");
        System.out.println(array.get(index) + "\n");

        index = 11;
        System.out.print("Set an array element at index " + index + " with value " + elementValue + ": \t");
        System.out.println(array.get(index));
        index = -11;
        System.out.print("Set an array element at index " + index + " with value " + elementValue + ": \t");
        System.out.println(array.get(index) + "\n");

        System.out.println("Current values of the array elements with indexes\t" + array + "\n");

        System.out.println("Get the length of the current array:\t" + array.size());
        System.out.println("Get the index of the array element with a value " + elementValue + ":\t"
                + array.indexOf(elementValue));
        System.out.println("Get the last index of the array element with a value " + elementValue + ":\t"
                + array.lastIndexOf(elementValue));
        System.out.println();
    }

    /**
     * Test the {@link OneDimBoundedArray} class for the Integer type.
     */
    private static void testIntegerArray() {
        System.out.println("*******************************************************************************");
        System.out.println("Test OneDimBoundedArray class for Integer type:");
        System.out.println("*******************************************************************************");
        System.out.println("Test Array with the Integer type values and positive indexes:");
        Integer[] arrayOfIntegers = {-1, 8, 12, 16, 20, 47, 29};
        OneDimBoundedArray<Integer> array1 = new OneDimBoundedArray<>(20, 26, arrayOfIntegers);
        testArray(array1, 1);
        System.out.println();

        System.out.println("Test Array with the Integer type values and negative indexes:");
        OneDimBoundedArray<Integer> array2 = new OneDimBoundedArray<>(-14, -8, arrayOfIntegers);
        testArray(array2, 16);
        System.out.println();
    }

    /**
     * Test the {@link OneDimBoundedArray} class for the String type.
     */
    private static void testStringArray() {
        System.out.println("*******************************************************************************");
        System.out.println("Test OneDimBoundedArray class for String type:");
        System.out.println("*******************************************************************************");
        String[] arrayOfStrings = {"Apple", "Banana ", "Orange", "Grape", "Mango", "Kiwi", "Lemon", "Plum"};
        int fromIndex = 4, toIndex = 11;
        OneDimBoundedArray<String> array1 = new OneDimBoundedArray<>(fromIndex, toIndex, arrayOfStrings);
        System.out.println("Test Array with the String type values and positive indexes:");
        testArray(array1, "Grape");

        fromIndex = 3; toIndex = 0;
        System.out.println("Create first array with indexes from = " + fromIndex + ", to = " + toIndex + ":");
        OneDimBoundedArray<String> array2 = new OneDimBoundedArray<>(fromIndex, toIndex, arrayOfStrings);
        System.out.println();

        /*
        fromIndex = 4; toIndex = 15;
        System.out.println("Create second array with indexes from = " + fromIndex + ", to = " + toIndex + ":");
        OneDimBoundedArray<String> array3 = new OneDimBoundedArray<>(fromIndex, toIndex, arrayOfStrings);
         */
    }

    /**
     * Main method to run the tests for the {@link OneDimBoundedArray} class.
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        testIntegerArray();
        testStringArray();
    }
}
