package task3;

/**
 * The {@code FindFibonacciNumbers} class provides a function for computing of Fibonacci numbers (up to the 92nd
 * integer) using an auxiliary array (static field). <p> The search for Fibonacci numbers is carried out according to
 * the following rule: {@code F(1) = F(2) = 1; F(n) = F(n - 2) + F(n - 1)}.
 * <p> The class supports a static {@code FIB_NUMS_ARRAY} array for storing Fibonacci numbers. At the first call,
 * the array is filled until the required number. At subsequent calls, the number either returns from the array,
 * or is calculated using the last two numbers stored in an array.
 * <p> Also provides a function to print the Fibonacci array.
 */
class FindFibonacciNumbers {
    /** The number of elements in the {@code FIB_NUMS_ARRAY} array. Also the maximum possible value that will be found. */
    private static final int ARR_ELEMS_NUMBER = 92;
    /** The index of the last calculated Fibonacci number in the {@code FIB_NUMS_ARRAY} array. */
    private static int lastCalculated = 2;
    /** The auxiliary static array (static field) to store Fibonacci numbers. */
    private static final long[] FIB_NUMS_ARRAY = new long[ARR_ELEMS_NUMBER];
    static {
        FIB_NUMS_ARRAY[0] = 1;
        FIB_NUMS_ARRAY[1] = 1;
    }

    /**
     * Finds the Fibonacci number at a given {@code numberIndex}.
     * @param numberIndex Fibonacci number's index;
     * @return Fibonacci number for a given index.
     */
    static long findFibonacciNumbers(int numberIndex) {
        if (numberIndex < 1 || numberIndex > ARR_ELEMS_NUMBER) {
            System.err.println("Invalid value of index. The allowed index value is from 1 to 92 including. Try again!");
            System.exit(1);
        }

        if (lastCalculated < numberIndex) {
            for (int n = lastCalculated; n < numberIndex; n++) {
                FIB_NUMS_ARRAY[n] = FIB_NUMS_ARRAY[n - 2] + FIB_NUMS_ARRAY[n - 1];
            }

            System.out.printf("There were calculated Fibonacci numbers from %d to %d including.\n",
                    ++lastCalculated, numberIndex);
            lastCalculated = numberIndex;
        } else {
            System.out.println("The Fibonacci number was taken from the array.");
        }

        return FIB_NUMS_ARRAY[numberIndex - 1];
    }

    /**
     * Prints Fibonacci numbers form the {@code FIB_NUMS_ARRAY} array up to and including the {@code lastCalculated}
     * number in array.
     */
    static void printFibonacciArray() {
        System.out.printf("The array of current Fibonacci numbers (index from 1 to %d including):\n", lastCalculated);
        int counter = 0;

        for (int i = 0; i < lastCalculated; i++) {
            if (counter == 6) {
                System.out.println();
                counter = 0;
            }

            System.out.printf("%-20d", FIB_NUMS_ARRAY[i]);
            counter++;
        }
    }

    /**
     * Calls the static methods of the {@link FindFibonacciNumbers} class to find the Fibonacci number at the specified
     * index. Prints this number and the current values of the {@code FIB_NUMS_ARRAY} array. The {@code args} are
     * not used.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int index = 9;
        System.out.printf("The Fibonacci number at the index %d:\t%d\n", index, findFibonacciNumbers(index));
        printFibonacciArray();
        System.out.println("\n");

        index = 5;
        System.out.printf("The Fibonacci number at the index %d:\t%d\n", index, findFibonacciNumbers(index));
        printFibonacciArray();
        System.out.println("\n");

        index = 21;
        System.out.printf("The Fibonacci number at the index %d:\t%d\n", index, findFibonacciNumbers(index));
        printFibonacciArray();
        System.out.println("\n");

        index = 92;
        System.out.printf("The Fibonacci number at the index %d:\t%d\n", index, findFibonacciNumbers(index));
        printFibonacciArray();
        System.out.println("\n");

        index = 100;
        System.out.printf("The Fibonacci number at the index %d:\n", index);
        findFibonacciNumbers(index);
    }
}
