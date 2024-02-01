package task3;

import java.util.Scanner;

public class BreakAndContinue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value of x:\t");
        double x = scanner.nextDouble();

        System.out.print("Enter value of n:\t");
        int n = scanner.nextInt();

        if (n < 1) {
            System.err.println("The value of n cannot be less than 1. Try again!");
            System.exit(1);
        }

        System.out.println("\nResults of the function calculation:");
        double y = 1;

        outerLoop:
        for (int i = 1; i <= n - 1; i++) {
            double sum = 0;
            int j;

            for (j = 0; j <= n; j++) {
                if (i == j + x) {
                    continue outerLoop;
                }

                if (j + x == 0) {
                    System.err.println("Calculation error: division by zero is not possible. Try again!");
                    break outerLoop;
                }

                sum += i / (j + x);
            }

            y *= sum;
            System.out.printf("i = %d\tsum(%d) = %f\ty(%d) = %f\n", i, i, sum, i, y);
        }

        System.out.printf("\ny = %f\n", y);
    }
}

