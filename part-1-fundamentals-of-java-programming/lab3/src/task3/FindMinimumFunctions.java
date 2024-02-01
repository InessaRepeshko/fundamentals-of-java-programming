package task3;

class FindMinimumFunctions {
    static void verifyInterval(double start, double end, double step) {
        if (start > end && step <= 0) {
            System.err.println("Incorrect interval values have been passed: step <= 0 and start > end. Try again!");
            System.exit(1);
        } else if (start > end) {
            System.err.println("Incorrect interval values have been passed: start > end. Try again!");
            System.exit(1);
        } else if (step <= 0) {
            System.err.println("Incorrect interval values have been passed: step <= 0. Try again!");
            System.exit(1);
        }
    }

    static double findMinFunctionValueUsingAbstractClass(double start, double end, double step, FindFunctionValueAbstractClass function) {
        double minValue = function.findFunctionValue(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = function.findFunctionValue(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    static void usingAbstractClass(double start, double end, double step) {
        verifyInterval(start, end, step);
        PowFunctionWithAbstractClass powerFunction = new PowFunctionWithAbstractClass();
        ExpFunctionWithAbstractClass exponentFunction = new ExpFunctionWithAbstractClass();
        System.out.println("First Method: using abstract class and derived classes.");
        System.out.println("The minimum value of a power function (x^2):\t\t"
                + findMinFunctionValueUsingAbstractClass(start, end, step, powerFunction));
        System.out.println("The minimum value of a exponent function (e^x):\t\t"
                + findMinFunctionValueUsingAbstractClass(start, end, step, exponentFunction) + "\n");
    }

    static double findMinFunctionValueUsingInterface(double start, double end, double step, Function function) {
        double minValue = function.findFunctionValue(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = function.findFunctionValue(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    static void usingInterface(double start, double end, double step) {
        verifyInterval(start, end, step);
        PowFunctionWithInterface powerFunction = new PowFunctionWithInterface();
        ExpFunctionWithInterface exponentFunction = new ExpFunctionWithInterface();
        System.out.println("Second Method: using interface and separate classes that implement it.");
        System.out.println("The minimum value of a power function (x^2):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, powerFunction));
        System.out.println("The minimum value of a exponent function (e^x):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, exponentFunction) + "\n");
    }

    static void usingAnonymousClasses(double start, double end, double step) {
        verifyInterval(start, end, step);
        System.out.println("Third Method: using interface and anonymous classes.");
        System.out.println("The minimum value of a power function (x^2):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, new Function() {
            @Override
            public double findFunctionValue(double x) {
                return Math.pow(x, 2);
            }
        }));
        System.out.println("The minimum value of a exponent function (e^x):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, new Function() {
            @Override
            public double findFunctionValue(double x) {
                return Math.exp(x);
            }
        }) + "\n");
    }

    static void usingLambdaExpressions(double start, double end, double step) {
        verifyInterval(start, end, step);
        System.out.println("Fourth Method: using lambda expressions.");
        System.out.println("The minimum value of a power function (x^2):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, x -> Math.pow(x, 2)));
        System.out.println("The minimum value of a exponent function (e^x):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, x -> Math.exp(x)) + "\n");
    }

    static double powerFunction(double x) {
        return Math.pow(x, 2);
    }

    static double exponentFunction(double x) {
        return Math.exp(x);
    }

    static void usingReferencesToMethods(double start, double end, double step) {
        verifyInterval(start, end, step);
        System.out.println("Fifth Method: using references to methods.");
        System.out.println("The minimum value of a power function (x^2):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, FindMinimumFunctions::powerFunction));
        System.out.println("The minimum value of a exponent function (e^x):\t\t"
                + findMinFunctionValueUsingInterface(start, end, step, FindMinimumFunctions::exponentFunction));
    }

    public static void main(String[] args) {
        /*
        double start = 5.0,
                end = -5.3,
                step = 0;
        System.out.println("INVALID DATA:\n" +
                "Interval for x:\nstart =\t\t" + start + ";\nend =\t\t" + end + ";\nstep =\t\t" + step + ".\n");
         */

        /*
        double start = 5.0,
                end = -5.3,
                step = 0.8;
        System.out.println("INVALID DATA:\n" +
                "Interval for x:\nstart =\t\t" + start + ";\nend =\t\t" + end + ";\nstep =\t\t" + step + ".\n");
         */

        /*
        double start = -5.0,
                end = 5.3,
                step = -2;
        System.out.println("INVALID DATA:\n" +
                "Interval for x:\nstart =\t\t" + start + ";\nend =\t\t" + end + ";\nstep =\t\t" + step + ".\n");
         */

        double start = -5.0,
                end = 5.3,
                step = 0.8;
        System.out.println("VALID DATA:\n" +
                "Interval for x:\nstart =\t\t" + start + ";\nend =\t\t" + end + ";\nstep =\t\t" + step + ".\n");

        usingAbstractClass(start, end, step);
        usingInterface(start, end, step);
        usingAnonymousClasses(start, end, step);
        usingLambdaExpressions(start, end, step);
        usingReferencesToMethods(start, end, step);
    }
}
