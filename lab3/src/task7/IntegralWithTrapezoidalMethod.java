package task7;

public class IntegralWithTrapezoidalMethod implements Integrable {
    @Override
    public double someFunction(double x) {
        return Math.pow(x, 2);
        /* return Math.cbrt(x); */
        /* return Math.sin(x); */
    }

    @Override
    public double integral(double start, double end, double accuracy) {
        if (start >= end) {
            System.err.println("Invalid interval passed. The start must be less than the end. Try again!");
            System.exit(1);
        }

        double step = (end - start) * accuracy;
        double area = 0;

        for (double x = start; x < end; x += step) {
            area += 0.5 * step * (someFunction(x) + someFunction(x + step));
        }

        return area;
    }
}
