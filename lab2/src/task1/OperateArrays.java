package task1;

import java.util.Arrays;
import java.util.Random;

/**
 * The {@code OperateArrays} class performs some operations on a two-dimensional array of integers
 * and an array of strings.
 * <p> It provides a traditional approach that uses loops and individual elements
 * and a functional approach that uses functions of the Arrays class (without loops).
 */
class OperateArrays {
    /** The number of rows in the array of integers and the number of items in the array of strings. */
    private static final int NUMBER_OF_ROWS = 5;

    /** The number of columns in the array of integers. */
    private static final int NUMBER_OF_COLUMNS = 3;

    /** The character used to fill in strings. */
    private static final char CHARACTER = 'N';

    /** The array of strings with test data for testing the operation on arrays with filling with multiple characters.*/
    private static final char[] CHARACTERS = new char[] {'A', 'B', 'C', 'B', 'C'};

    /**
     * Fills the provided two-dimensional array of integers with random positive odd numbers between 3 and 31.
     * @param intArray two-dimensional array of integers.
     */
    private static void fillIntArray(int[][] intArray) {
        Random random = new Random();

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                intArray[i][j] = random.nextInt(15) * 2 + 3;
            }
        }
    }

    /**
     * Prints the provided two-dimensional array of integers to the console.
     * @param intArray two-dimensional array of integers.
     */
    private static void printIntArray(int[][] intArray) {
        for (int[] row : intArray) {
            System.out.print('[');

            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + ", ");
            }

            System.out.println(row[row.length - 1] + "]");
        }
    }

    /**
     * Finds the minimum value in the provided row of an array of integers.
     * @param intArrayRow row of an array of integers;
     * @return minimum value in the provided row of an array of integers.
     */
    private static int findMinValueInRow(int[] intArrayRow) {
        int minValue = intArrayRow[0];

        for (int i = 1; i < intArrayRow.length; i++) {
            if (intArrayRow[i] < minValue) {
                minValue = intArrayRow[i];
            }
        }

        return minValue;
    }

    /**
     * Fills the provided array of strings with items consisting of the {@value #CHARACTER} character or multiple
     * characters from the '{@link #CHARACTERS}' array according to {@code fillWithMultiChars} flag based on the
     * minimum value in each row of the array of integers.
     * @param stringArray array of strings;
     * @param intArray two-dimensional array of integers;
     * @param fillWithMultiChars flag to check which characters to fill the strings in the array of strings with.
     */
    private static void fillStringArray(String[] stringArray, int[][] intArray, boolean fillWithMultiChars) {
        if (fillWithMultiChars) {
            String[] characterStrings = new String[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                characterStrings[i] = String.valueOf(CHARACTERS[i]);
                stringArray[i] = characterStrings[i].repeat(findMinValueInRow(intArray[i]));
            }
        } else {
            String characterString = String.valueOf(CHARACTER);

            for (int i = 0; i < stringArray.length; i++) {
                stringArray[i] = characterString.repeat(findMinValueInRow(intArray[i]));
            }
        }
    }

    /**
     * Sorts the provided array of strings in reverse alphabetical order using bubble sort.
     * @param stringArray array of strings.
     */
    private static void sortStringArrayByReverseAlphabet(String[] stringArray) {
        boolean isUnsorted = true;

        while (isUnsorted) {
            isUnsorted = false;

            for (int i = 0; i < stringArray.length - 1; i++) {
                if (stringArray[i].compareTo(stringArray[i + 1]) < 0) {
                    String tempString = stringArray[i];
                    stringArray[i] = stringArray[i + 1];
                    stringArray[i + 1] = tempString;
                    isUnsorted = true;
                }
            }
        }
    }

    /**
     * Prints the provided array of strings to the console.
     * @param stringArray array of strings.
     */
    private static void printStringArray(String[] stringArray) {
        for (String s : stringArray) {
            System.out.println(s);
        }
    }

    /**
     * Verifies the given two-dimensional array of integers for compliance with the following requirements:
     * <ul><li> The number of all rows of the given array must be equal to {@value #NUMBER_OF_ROWS}.</li>
     * <li> The number of all columns must be equal to {@value #NUMBER_OF_COLUMNS}.</li>
     * <li> The array must be filled with random positive odd integers from 3 to 31.</li>
     * <li> If any of the requirements are not met, an error message is printed and the program is closed.</li></ul>
     * @param intArray two-dimensional array of integers;
     * @param isTraditionalApproach flag to check which approach should be used for verification.
     */
    private static void verifyIntArray(int[][] intArray, boolean isTraditionalApproach) {
        if (intArray.length != NUMBER_OF_ROWS) {
            System.err.printf("A two-dimensional array with an incorrect number of rows was passed. " +
                    "\nThe number of rows should be %d. Try again!", NUMBER_OF_ROWS);
            System.exit(1);
        } else {
            if (isTraditionalApproach) {
                for (int[] row : intArray) {
                    if (row.length != NUMBER_OF_COLUMNS) {
                        System.err.printf("A two-dimensional array with an incorrect number of columns was passed. " +
                                "\nThe number of columns should be %d. Try again!", NUMBER_OF_COLUMNS);
                        System.exit(1);
                    }

                    for (int element : row) {
                        if (element < 3 || element > 31 || element % 2 == 0) {
                            System.err.println("There are invalid numbers in the array. \nThe array must be filled " +
                                    "with random positive odd integers from 3 to 31 including.");
                            System.exit(1);
                        }
                    }
                }
            } else {
                Arrays.stream(intArray).forEach(row -> {
                    if (row.length != NUMBER_OF_COLUMNS) {
                        System.err.printf("A two-dimensional array with an incorrect number of columns was passed. " +
                                "\nThe number of columns should be %d. Try again!", NUMBER_OF_COLUMNS);
                        System.exit(1);
                    }

                    Arrays.stream(row).forEach(element -> {
                        if (element < 3 || element > 31 || element % 2 == 0) {
                            System.err.println("There are invalid numbers in the array. \nThe array must be filled " +
                                    "with random positive odd integers from 3 to 31 including. Try again!");
                            System.exit(1);
                        }
                    });
                });
            }
        }
    }

    /**
     * Operates on arrays using the traditional approach.
     * <p> Creates the two-dimensional array of integers and fills it with random positive odd numbers. Prints
     * the array of integers. Fills the array of strings with {@value #CHARACTER} character based on the minimum
     * value in each row of the array of integers. Prints the array of strings. Sorts the array of strings in
     * reverse alphabetical order and prints it.
     */
    static void usingTraditionalApproach() {
        int[][] intArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        fillIntArray(intArray);
        System.out.println("Array of integers:");
        printIntArray(intArray);

        String[] stringArray = new String[NUMBER_OF_ROWS];
        fillStringArray(stringArray, intArray, false);
        System.out.println("Array of strings before sorting:");
        printStringArray(stringArray);

        sortStringArrayByReverseAlphabet(stringArray);
        System.out.println("Array of strings after sorting:");
        printStringArray(stringArray);
    }

    /**
     * Operates on arrays using the traditional approach and using the test array of integers and filling the array
     * of strings with multiple characters or specified character.
     * <p> Verifies and prints the array of integers. Fills the array of strings with the {@value #CHARACTER} character
     * or multiple characters from the '{@link #CHARACTERS}' array according to {@code fillWithMultiChars} flag
     * based on the minimum value in each row of the array of integers. Prints the array of strings. Sorts the array
     * of strings in reverse alphabetical order and prints it.
     * @param intArray two-dimensional array of integers;
     * @param fillWithMultiChars flag to check which characters to fill the strings in the array of strings with.
     */
    static void usingTraditionalApproach(int[][] intArray, boolean fillWithMultiChars) {
        verifyIntArray(intArray, true);
        System.out.println("Array of integers:");
        printIntArray(intArray);

        String[] stringArray = new String[NUMBER_OF_ROWS];
        fillStringArray(stringArray, intArray, fillWithMultiChars);
        System.out.println("Array of strings before sorting:");
        printStringArray(stringArray);

        sortStringArrayByReverseAlphabet(stringArray);
        System.out.println("Array of strings after sorting:");
        printStringArray(stringArray);
    }

    /**
     * Operates on arrays using the functional approach.
     * <p> Creates the two-dimensional array of integers and fills it with random positive odd numbers. Prints
     * the array of integers. Fills the array of strings with {@value #CHARACTER} character based on the minimum
     * value in each row of the array of integers. Prints the array of strings. Sorts the array of strings in
     * reverse alphabetical order and prints it.
     */
    static void usingFunctionalApproach() {
        int[][] intArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        Random random = new Random();
        Arrays.stream(intArray).forEach(row -> Arrays.setAll(row, i -> random.nextInt(15) * 2 + 3));
        System.out.println("Array of integers:");
        Arrays.stream(intArray).forEach(row -> System.out.println(Arrays.toString(row)));

        String characterString = String.valueOf(CHARACTER);
        String[] stringArray = new String[NUMBER_OF_ROWS];
        Arrays.setAll(stringArray, j -> {
            int minNumberInRow = Arrays.stream(intArray[j]).min().orElse(0);
            return characterString.repeat(minNumberInRow);
        });
        System.out.println("Array of strings before sorting:");
        Arrays.stream(stringArray).forEach(System.out::println);

        Arrays.sort(stringArray, (s1, s2) -> -s1.compareTo(s2));
        System.out.println("Array of strings after sorting:");
        Arrays.stream(stringArray).forEach(System.out::println);
    }


    /** Operates on arrays using the functional approach and using the test array of integers and filling the array
     * of strings with multiple characters or specified character.
     * <p> Verifies and prints the array of integers. Fills the array of strings with the {@value #CHARACTER} character
     * or multiple characters from the '{@link #CHARACTERS}' array according to {@code fillWithMultiChars} flag
     * based on the minimum value in each row of the array of integers. Prints the array of strings. Sorts the array
     * of strings in reverse alphabetical order and prints it.
     * @param intArray two-dimensional array of integers;
     * @param fillWithMultiChars flag to check which characters to fill the strings in the array of strings with.
     */
    static void usingFunctionalApproach(int[][] intArray, boolean fillWithMultiChars) {
        verifyIntArray(intArray, false);
        System.out.println("Array of integers:");
        Arrays.stream(intArray).forEach(row -> System.out.println(Arrays.toString(row)));

        String[] stringArray = new String[NUMBER_OF_ROWS];

        if (fillWithMultiChars) {
            String[] characterStrings = new String[NUMBER_OF_ROWS];
            Arrays.setAll(characterStrings, i -> String.valueOf(CHARACTERS[i]));
            Arrays.setAll(stringArray, j -> {
                int minNumberInRow = Arrays.stream(intArray[j]).min().orElse(0);
                return characterStrings[j].repeat(minNumberInRow);
            });
        } else {
            String characterString = String.valueOf(CHARACTER);
            Arrays.setAll(stringArray, j -> {
                int minNumberInRow = Arrays.stream(intArray[j]).min().orElse(0);
                return characterString.repeat(minNumberInRow);
            });
        }

        System.out.println("Array of strings before sorting:");
        Arrays.stream(stringArray).forEach(System.out::println);

        Arrays.sort(stringArray, (s1, s2) -> -s1.compareTo(s2));
        System.out.println("Array of strings after sorting:");
        Arrays.stream(stringArray).forEach(System.out::println);
    }

    /**
     * Calls static methods of the {@code OperateArrays} class demonstrating the traditional and functional approaches
     * with different test data. The {@code args} are not used.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("1.1. Operate arrays using the traditional approach with creating default arrays:");
        usingTraditionalApproach();

        System.out.println("\n1.2. Operate arrays using the functional approach with creating default arrays:");
        usingFunctionalApproach();

        int[][] validTestArray = new int[][] {
                {17, 31, 13},
                {7, 29, 11},
                {29, 17, 11},
                {25, 9, 3},
                {9, 27, 15}
        };
        System.out.println("\n\n2.1. Operate arrays using the traditional approach and using the test array of " +
                "integers \nand filling the array of strings with multiple characters:");
        usingTraditionalApproach(validTestArray, true);

        System.out.println("\n2.2. Operate arrays using the functional approach and using the test array of " +
                "integers \nand filling the array of strings with multiple characters:");
        usingFunctionalApproach(validTestArray, true);

        /*
        int[][] invalidTestArray1 = new int[][] {
                {17, 31, 13},
                {7, 29, 11},
                {29, 17, 11},
                {25, 9, 3},
                {9, 27, 15},
                {17, 31, 13}
        };
        System.out.println("\n\n3. Operate arrays using the traditional approach " +
                "\nand using the test array with invalid number of rows:");
        usingTraditionalApproach(invalidTestArray1, false);
        */

        /*
        int[][] invalidTestArray2 = new int[][] {
                {17, 31, 13, 19},
                {7, 29, 11, 31},
                {29, 17, 11, 31},
                {25, 9, 3, 15},
                {9, 27, 15, 27}
        };
        System.out.println("\n\n4. Operate arrays using the traditional approach " +
                "\nand using the test array with invalid number of columns:");
        usingTraditionalApproach(invalidTestArray2, false);
        */

        int[][] invalidTestArray3 = new int[][] {
                {17, 31, 13},
                {7, 29, 1},
                {29, 11, 11},
                {25, -9, 3},
                {89, 9, 15}
        };
        System.out.println("\n\n5. Operate arrays using the functional approach " +
                "\nand using the test array with invalid data:");
        usingFunctionalApproach(invalidTestArray3, true);
    }
}
