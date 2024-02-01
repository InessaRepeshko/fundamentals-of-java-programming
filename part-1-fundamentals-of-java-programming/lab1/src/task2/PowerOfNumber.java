package task2;

import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value for n in the range of 0 to 10 including:\t");
        int n = scanner.nextInt();

        if (n < 0 || n > 10) {
            System.err.println("The value n does not belong to the valid range from 0 to 10 including.");
            System.exit(1);
        }

        int base = 8;
        System.out.printf("\nResults of calculating %d to the power of %d (including):\n", base, n);
        System.out.println("\nUsing arithmetic operations:");

        for (int i = 0; i <= n; i++) {
            int result = (int) Math.pow(base, i);
            System.out.printf("%d ^ %d = %d\n", base, i, result);
        }

        System.out.println("\nUsing bitwise operations:");

        for (int i = 0; i <= n; i++) {
            int result = 1 << 3 * i;
            System.out.printf("%d ^ %d = %d\n", base, i, result);
        }
    }
}

