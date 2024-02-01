package task3;

class ExpFunctionWithAbstractClass extends FindFunctionValueAbstractClass {
    @Override
    double findFunctionValue(double x) {
        return Math.exp(x);
    }
}
