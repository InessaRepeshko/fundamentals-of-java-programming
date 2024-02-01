package task2;

import java.util.Arrays;

/**
 * The {@code FindPrimeNumbers} class implements the Eratosthenes sieve algorithm for finding prime numbers without
 * division and getting the remainder from division and prints the found prime numbers.
 */
class FindPrimeNumbers {
    /** The number of array elements to search for prime numbers. */
    private static final int ARR_ELEMS_NUMBER = 300;
    /** The negative value that is used to indicate non-prime numbers in the array. */
    private static final int NEGATIVE_NUMBER = -1;

    /**
     * Creates array of integers filled with consecutive positive values in the range from 1 to
     * {@value #ARR_ELEMS_NUMBER}.
     * @return array of integers filled with consecutive positive values.
     */
    static int[] createArrayOfNumbers() {
        int[] arrayOfNumbers = new int[ARR_ELEMS_NUMBER];
        Arrays.setAll(arrayOfNumbers, i -> i + 1);

        return arrayOfNumbers;
    }

    /**
     * Finds prime numbers in the range from 1 to {@value #ARR_ELEMS_NUMBER} by the Eratosthenes Sieve algorithm.
     * The {@code newArray} array is filled with consecutive positive integer numbers and numbers that are not prime
     * are replaced with the {@value #NEGATIVE_NUMBER} value.
     * @param newArray array of integers filled with consecutive positive values that must be sorted.
     */
    static void findPrimeNumbers(int[] newArray) {
        newArray[0] = NEGATIVE_NUMBER;

        for (int i = 2; i * i <= ARR_ELEMS_NUMBER; i++) {
            if (newArray[i - 1] != NEGATIVE_NUMBER) {
                for (int j = i + i; j <= ARR_ELEMS_NUMBER; j += i) {
                    if (newArray[j - 1] != NEGATIVE_NUMBER) {
                        newArray[j - 1] = NEGATIVE_NUMBER;
                    }
                }
            }
        }
    }

    /**
     * Prints the prime numbers as formatted text. The {@value #NEGATIVE_NUMBER} values in the {@code newArray}
     * array are not printed.
     * @param newArray sorted array of prime numbers.
     */
    static void printPrimeNumbers(int[] newArray) {
        int counter = 0;

        for (int element : newArray) {
            if (element != NEGATIVE_NUMBER) {
                if (counter == 21) {
                    System.out.println();
                    counter = 0;
                }

                System.out.print(element + "\t");
                counter++;
            }
        }
    }

    /**
     * Calls static methods of the {@link FindPrimeNumbers} class to find and print prime numbers. The {@code args}
     * are not used.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        int[] newArray = createArrayOfNumbers();
        findPrimeNumbers(newArray);
        System.out.println("The prime numbers from an array of numbers from 1 to 300:");
        printPrimeNumbers(newArray);
    }
}
