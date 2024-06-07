package task7;

public class Main {
    public static void main(String[] args) {
        IntegralWithRectangularMethod firstIntegrator = new IntegralWithRectangularMethod();
        IntegralWithTrapezoidalMethod secondIntegrator = new IntegralWithTrapezoidalMethod();

        /* double start = 2, end = 0, accuracy = 0.0001; */
        /* double start = 5, end = 5, accuracy = 0.0001; */
        double start = -5, end = 2, accuracy = 0.0001;
        System.out.println("Definite integral for the power function x^2\n"
                + "on the interval from " + start + " to " + end
                + "\nis equal to the area of the figure calculated:"
                + "\n1) with calculation accuracy " + accuracy + " by:");
        /*
        double start = 1, end = 10, accuracy = 0.0001;
        System.out.println("Definite integral for the cubic root function x^(-1/3)\n"
                + "on the interval from " + start + " to " + end
                + "\nis equal to the area of the figure calculated:"
                + "\n1) with calculation accuracy " + accuracy + " by:");
         */
        /*
        double start = 0, end = Math.PI, accuracy = 0.0001;
        System.out.println("Definite integral for the sine function sin(x)\n"
                + "on the interval from " + start + " to " + end + " (PI)"
                + "\nis equal to the area of the figure calculated:"
                + "\n1) with calculation accuracy " + accuracy + " by:");
         */

        System.out.println("\t* the rectangular method:\tS = " + firstIntegrator.integral(start, end, accuracy) + ";"
                + "\n\t* the trapezoidal method:\tS = " + secondIntegrator.integral(start, end, accuracy) + ".");
        accuracy = 0.00000001;
        System.out.println("2) with calculation accuracy " + accuracy + " by:");
        System.out.println("\t* the rectangular method:\tS = " + firstIntegrator.integral(start, end, accuracy) + ";"
                + "\n\t* the trapezoidal method:\tS = " + secondIntegrator.integral(start, end, accuracy) + ".");
    }
}
