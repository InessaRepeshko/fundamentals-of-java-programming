package task5;

import java.util.Arrays;

public class Circle implements Comparable<Circle>{
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            System.err.println("Invalid circle radius passed.\n" +
                    "The radius must be greater than zero. Try again!");
            System.exit(1);
        }

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int compareTo(Circle circle) {
        return Double.compare(this.getRadius(), circle.getRadius());
    }

    @Override
    public String toString() {
        return "Circle radius is\t" + getRadius() + "\tcm.";
    }

    public static void printCirclesArray(Circle[] circles) {
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }

    public static void main(String[] args) {
        System.out.println("Initial array of circles:");
        /*
        Circle[] circles = {
                new Circle(-0.9),
                new Circle(10)
        };
        */
        /*
        Circle[] circles = {
                new Circle(9),
                new Circle(0)
        };
        */

        Circle[] circles = {
                new Circle(12.34),
                new Circle(23.45),
                new Circle(0.99),
                new Circle(10),
                new Circle(20.2),
                new Circle(3.78),
                new Circle(9.12)
        };
        printCirclesArray(circles);

        System.out.println("\nSorted array of circles ascending by radius:");
        Arrays.sort(circles);
        printCirclesArray(circles);
    }
}
