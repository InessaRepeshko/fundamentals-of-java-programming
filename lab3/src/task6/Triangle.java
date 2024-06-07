package task6;

import java.util.Arrays;
import java.util.Comparator;

public class Triangle {
    private double edgeA, edgeB, edgeC;

    public Triangle(double edgeA, double edgeB, double edgeC) {
        if (edgeA <= 0
                || edgeB <= 0
                || edgeC <= 0) {
            System.err.println("Invalid edge of triangle passed.\n" +
                    "The edge must be greater than zero. Try again!");
            System.exit(1);
        }

        if (edgeB + edgeC <= edgeA
                || edgeA + edgeC <= edgeB
                || edgeA + edgeB <= edgeC) {
            System.err.println("Invalid edge of triangle passed.\n" +
                    "The sum of lengths of two edges must be greater than length of the third edge. Try again!");
            System.exit(1);
        }

        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }

    public double calculateArea() {
        double a = getEdgeA();
        double b = getEdgeB();
        double c = getEdgeC();
        return 0.25 * Math.sqrt((a + b + c) * (b + c - a) * (a + b - c));
    }

    @Override
    public String toString() {
        return "Triangle area is\t" + calculateArea()
                + "\tcm with edges:\t"
                + "a = " + getEdgeA()
                + "    b = " + getEdgeB()
                + "    c = " + getEdgeC()
                + ".";
    }

    public static void printTrianglesArray(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }

    public static void main(String[] args) {
        System.out.println("Initial array of triangles:");
        /*
        Triangle[] triangles = {
                new Triangle(10.0, 9, 8),
                new Triangle(-2, 10, 10)
        };
         */
        /*
        Triangle[] triangles = {
                new Triangle(0.09, 8, 0),
                new Triangle(2, 3, 4)
        };
         */
        /*
        Triangle[] triangles = {
                new Triangle(5, 4, 3),
                new Triangle(4, 3, 7)
        };
         */

        Triangle[] triangles = {
                new Triangle(4, 3, 5),
                new Triangle(5.9, 5.2, 7.3),
                new Triangle(6, 13,12),
                new Triangle(10.1, 11.2, 12.3),
                new Triangle(8.5, 8.5, 8.5),
                new Triangle(5, 12, 13)
        };
        printTrianglesArray(triangles);

        System.out.println("\nSorted array of triangles descending by area:");
        Arrays.sort(triangles, new Comparator<Triangle>() {
            @Override
            public int compare(Triangle triangle1, Triangle triangle2) {
                return Double.compare(triangle2.calculateArea(), triangle1.calculateArea());
            }
        });
        printTrianglesArray(triangles);
    }
}
