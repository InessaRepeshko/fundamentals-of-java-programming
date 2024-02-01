package task4;

import java.util.List;
import java.util.Optional;

public class NumberListOperationsTest {
    private static <T extends Number> void printNumberList(List<T> list) {
        System.out.println(list);
    }

    private static <T extends Number> void printLastNegativeNumber(Optional<T> lastNegativeNumber) {
        if (lastNegativeNumber.isPresent()) {
            System.out.print(lastNegativeNumber.get());
        } else {
            System.out.println("No negative elements found.");
        }
    }

    private static <T extends Number> void testNumberListOperations(List<T> numberList) {
        System.out.println("Initial List:");
        printNumberList(numberList);

        System.out.println("Test finding the index of the first zero element:\t"
                + NumberListOperations.findIndexOfFirstZeroNumber(numberList));

        System.out.println("Test finding the count of negative numbers:\t\t\t"
                + NumberListOperations.findCountOfNegativeNumbers(numberList));

        Optional<T> lastNegativeNumber = NumberListOperations.getLastNegativeNumber(numberList);
        System.out.print("Test getting the last negative element:\t\t\t\t");
        printLastNegativeNumber(lastNegativeNumber);
        System.out.println("\n");
    }

    private static <T extends Number> void testOperationsWithInteger() {
        System.out.println("*******************************************************************************");
        System.out.println("Test NumberListOperations class generic functions for Integer type:");
        System.out.println("*******************************************************************************");
        List<Integer> firstListOfIntegers = List.of(-2, 0, 1, -3, -5);
        List<Integer> secondListOfIntegers = List.of(4, 8, 2, 3, 5);
        System.out.println("1. Test for first List of Integers:");
        testNumberListOperations(firstListOfIntegers);
        System.out.println("2. Test for second List of Integers:");
        testNumberListOperations(secondListOfIntegers);
    }

    private static <T extends Number> void testOperationsWithDouble() {
        System.out.println("*******************************************************************************");
        System.out.println("Test NumberListOperations class generic functions for Double type:");
        System.out.println("*******************************************************************************");
        List<Double> firstListOfDoubles = List.of(-2.8, 0.0, 2.2, -3.0, -6.9);
        List<Double> secondListOfDoubles = List.of(3.2, 4.5, 1.0, 3.5, 2.8);
        System.out.println("1. Test for first List of Doubles:");
        testNumberListOperations(firstListOfDoubles);
        System.out.println("2. Test for second List of Doubles:");
        testNumberListOperations(secondListOfDoubles);
    }

    public static void main(String[] args) {
        testOperationsWithInteger();
        testOperationsWithDouble();
    }
}


