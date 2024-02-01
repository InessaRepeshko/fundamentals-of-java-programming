package task7;

public class IntegralWithRectangularMethod implements Integrable {
    @Override
    public double someFunction(double x) {
        return Math.pow(x, 2);
        /* return Math.cbrt(x); */
        /* return Math.sin(x); */
    }
}
