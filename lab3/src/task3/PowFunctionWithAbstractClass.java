package task3;

class PowFunctionWithAbstractClass extends FindFunctionValueAbstractClass {
    @Override
    double findFunctionValue(double x) {
        return Math.pow(x, 2);
    }
}
