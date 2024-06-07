package task3;

class ExpFunctionWithInterface implements Function {
    @Override
    public double findFunctionValue(double x) {
        return Math.exp(x);
    }
}
