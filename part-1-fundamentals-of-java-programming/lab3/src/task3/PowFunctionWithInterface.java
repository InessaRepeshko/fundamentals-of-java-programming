package task3;

class PowFunctionWithInterface implements Function {
    @Override
    public double findFunctionValue(double x) {
        return Math.pow(x, 2);
    }
}
