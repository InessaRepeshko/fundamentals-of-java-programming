package task3;

import java.util.Arrays;

public class ArrayOperationsTest {
    private static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static <T> void testSwapGroupsOfElements(T[] firstArray) {
        System.out.println("Initial first array:");
        printArray(firstArray);
        System.out.println();

        int srcBegin = 0, srcEnd = 1, dstBegin = -3;
        System.out.println("Test functionality of swapping two groups of elements,\n"
                + "with srcBegin=" + srcBegin + "\t\tsrcEnd=" + srcEnd + "\tdstBegin=" + dstBegin + ":\t"
                + ArrayOperations.swapGroupsOfElements(srcBegin, srcEnd, firstArray, dstBegin));
        System.out.println("First array after swapping:");
        printArray(firstArray);
        System.out.println();

        srcBegin = 1; srcEnd = 3; dstBegin = 2;
        System.out.println("Test functionality of swapping two groups of elements,\n"
                + "with srcBegin=" + srcBegin + "\t\tsrcEnd=" + srcEnd + "\tdstBegin=" + dstBegin + ": \t"
                + ArrayOperations.swapGroupsOfElements(srcBegin, srcEnd, firstArray, dstBegin));
        System.out.println("First array after swapping:");
        printArray(firstArray);
        System.out.println();
    }

    private static <T> void testSwapAdjacentElements(T[] firstArray, T[] secondArray, T[] thirdArray) {
        System.out.println("Test swapping of all pairs of adjacent elements\n"
                + "(with even and odd index) for first array:\t" + ArrayOperations.swapAdjacentElements(firstArray));
        System.out.println("First array after swapping:");
        printArray(firstArray);
        System.out.println();

        System.out.println("Initial second array:");
        printArray(secondArray);
        System.out.println();

        System.out.println("Test swapping of all pairs of adjacent elements\n"
                + "(with even and odd index) for second array:\t" + ArrayOperations.swapAdjacentElements(secondArray));
        System.out.println("Second array after swapping:");
        printArray(secondArray);
        System.out.println();

        System.out.println("Initial third array:");
        printArray(thirdArray);
        System.out.println();

        System.out.println("Test swapping of all pairs of adjacent elements\n"
                + "(with even and odd index) for third array:\t" + ArrayOperations.swapAdjacentElements(thirdArray));
        System.out.println("Third array after swapping:");
        printArray(thirdArray);
        System.out.println();
    }

    private static <T> void testReplaceGroupOfElements(T[] firstArray, T[] secondArray, T[] thirdArray) {
        int srcBegin = 1, dstBegin = 0, dstEnd = 2;
        System.out.println("Test replacing a group of elements of first array with elements of second array\n"
                + "with srcBegin=" + srcBegin + "\tdstBegin=" + dstBegin + "\tdstEnd=" + dstEnd + ":\t"
                + ArrayOperations.replaceGroupOfElements(secondArray, 1, firstArray, 0, 2));
        System.out.println("First array after replacing:");
        printArray(firstArray);
        System.out.println("Second array after replacing:");
        printArray(secondArray);
        System.out.println();

        srcBegin = 0; dstBegin = 0; dstEnd = 3;
        System.out.println("Test replacing a group of elements of first array with elements of third array\n"
                + "with srcBegin=" + srcBegin + "\tdstBegin=" + dstBegin + "\tdstEnd=" + dstEnd + ":\t"
                + ArrayOperations.replaceGroupOfElements(thirdArray, srcBegin, firstArray, dstBegin, dstEnd));
        System.out.println("First array after replacing:");
        printArray(firstArray);
        System.out.println("Third array after replacing:");
        printArray(thirdArray);
        System.out.println();
    }

    private static <T> void testOperations(T[] firstArray, T[] secondArray, T[] thirdArray) {
        testSwapGroupsOfElements(firstArray);
        testSwapAdjacentElements(firstArray, secondArray, thirdArray);
        testReplaceGroupOfElements(firstArray, secondArray, thirdArray);
    }
    private static <T> void testOperationsWithInteger() {
        System.out.println("***************************************************************************");
        System.out.println("Test ArrayOperations class generic functions for Integer type:");
        System.out.println("***************************************************************************");
        Integer[] firstArrayOfIntegers = { 5, 3, 1, 0, -4};
        Integer[] secondArrayOfIntegers = {7};
        Integer[] thirdArrayOfIntegers = {4, -6, -7};
        testOperations(firstArrayOfIntegers, secondArrayOfIntegers, thirdArrayOfIntegers);
        System.out.println();
    }

    private static <T> void testOperationsWithDouble() {
        System.out.println("***************************************************************************");
        System.out.println("Test ArrayOperations class generic functions for Double type:");
        System.out.println("***************************************************************************");
        Double[] firstArrayOfDoubles = {5.9, -3.5, 1.8, 1.6, -2.7};
        Double[] secondArrayOfDoubles = {2.6};
        Double[] thirdArrayOfDoubles = {4.8, -6.9, -7.9};
        testOperations(firstArrayOfDoubles, secondArrayOfDoubles, thirdArrayOfDoubles);
        System.out.println();
    }

    private static <T> void testOperationsWithString( ) {
        System.out.println("***************************************************************************");
        System.out.println("Test ArrayOperations class generic functions for String type:");
        System.out.println("***************************************************************************");
        String[] firstArrayOfStrings = {"Apple", "Banana", "Orange", "Grape", "Mango"};
        String[] secondArrayOfStrings = {"Peach"};
        String[] thirdArrayOfStrings = {"Kiwi", "Lemon", "Plum"};
        testOperations(firstArrayOfStrings, secondArrayOfStrings, thirdArrayOfStrings);
        System.out.println();
    }

    public static void main(String[] args) {
        testOperationsWithInteger();
        testOperationsWithDouble();
        testOperationsWithString();
    }
}
