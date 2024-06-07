package task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class IntegerNumbers {
    private static int findSumOfNumberDigits(int number) {
        int sumOfNumberDigits = 0;

        while (number > 0) {
            sumOfNumberDigits += number % 10;
            number /= 10;
        }

        return sumOfNumberDigits;
    }

    private static class DigitSumComparator implements Comparator<Integer> {
        private final boolean ascendingOrder;

        public DigitSumComparator(boolean ascendingOrder) {
            this.ascendingOrder = ascendingOrder;
        }

        @Override
        public int compare(Integer firstNumber, Integer secondNumber) {
            if (this.ascendingOrder) {
                return Integer.compare(findSumOfNumberDigits(firstNumber), findSumOfNumberDigits(secondNumber));
            } else {
                return Integer.compare(findSumOfNumberDigits(secondNumber), findSumOfNumberDigits(firstNumber));
            }
        }
    }

    private static void writeInFile(String outFileName,
                                    Integer[] numbers) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outFileName)))) {
            for (Integer number : numbers) {
                writer.print(number + " ");
            }
        }
    }

    private static Integer[] readFromFile(String inFileName) throws NonPositiveIntegerException, IOException {
        Integer[] numbers = {};

        try (BufferedReader reader = new BufferedReader(new FileReader(inFileName));
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();

                if (number < 0) {
                    throw new NonPositiveIntegerException(number);
                }

                Integer[] array = new Integer[numbers.length + 1];
                System.arraycopy(numbers, 0, array, 0, numbers.length);
                array[array.length - 1] = number;
                numbers = array;
            }
        }

        return numbers;
    }

    public static void sortIntegerNumbers(String inFileName,
                                          String firstOutFileName,
                                          String secondOutFileName) throws NonPositiveIntegerException, IOException {
        Integer[] numbers = readFromFile(inFileName);
        Arrays.sort(numbers, new DigitSumComparator(true));
        writeInFile(firstOutFileName, numbers);
        Arrays.sort(numbers, new DigitSumComparator(false));
        writeInFile(secondOutFileName, numbers);
    }

    public static void main(String[] args) {
        String path = "resources/task2/";

        try {
            sortIntegerNumbers(path + "InputValid.txt",
                    path + "OutputValidSortedAsc.txt",
                    path + "OutputValidSortedDesc.txt");
            /*
            sortIntegerNumbers(path + "InputInvalidNonPositive.txt",
                    path + "OutputInvalidNonPositiveFirst.txt",
                    path + "OutputInvalidNonPositiveSecond.txt");
             */
            /*
            sortIntegerNumbers(path + "InputInvalidString.txt",
                    path + "OutputInvalidStingFirst.txt",
                    path + "OutputInvalidStingSecond.txt");
             */
            /*
            sortIntegerNumbers(path + "InputInvalidNonExistent.txt",
                    path + "OutputInvalidNonExistentFirst.txt",
                    path + "OutputInvalidNonExistentSecond.txt");
             */
        } catch (FileNotFoundException e) {
            System.err.println("Failed to read file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to write to file.");
            e.printStackTrace();
        } catch (NonPositiveIntegerException e) {
            System.err.println("Wrong numeric value.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Wrong data format.");
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
