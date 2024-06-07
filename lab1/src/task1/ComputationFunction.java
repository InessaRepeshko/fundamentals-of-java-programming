package task1;

import java.util.Scanner;

public class ComputationFunction {
    static final int ITERATIONS_COUNT = 17;

    public static double compute(double x) {
        double y;

        if (x < 7) {
            y = 3 * x;

            for (int k = 1; k <= ITERATIONS_COUNT; k++) {
                y += Math.pow(Math.sin(x - 7), k);
            }
        } else {
            y = 23 - (2 * Math.exp(7 - x));
        }

        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of the start of the interval:\t");
        double start = scanner.nextDouble();

        System.out.print("Enter the value of the end of the interval:\t\t");
        double end = scanner.nextDouble();

        System.out.print("Enter the value of the step size:\t");
        double step = scanner.nextDouble();

        if (start > end || step <= 0) {
            System.out.println("Invalid interval or step values were entered. Try again!");
            System.exit(1);
        }

        System.out.println("The result of calculating the function:");

        for (double x = start; x <= end; x += step) {
            double y = compute(x);
            System.out.printf("x = %f\ty = %f\n", x, y);
        }
    }
}

