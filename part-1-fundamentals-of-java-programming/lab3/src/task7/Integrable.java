package task7;

@FunctionalInterface
public interface Integrable {
    double someFunction(double x);

    default double integral(double start, double end, double accuracy) {
        if (start >= end) {
            System.err.println("Invalid interval passed. The start must be less than the end. Try again!");
            System.exit(1);
        }

        double step = (end - start) * accuracy;
        double area = 0;

        for (double x = start; x < end; x += step) {
            area += someFunction(x) * step;
        }

        return area;
    }
}
