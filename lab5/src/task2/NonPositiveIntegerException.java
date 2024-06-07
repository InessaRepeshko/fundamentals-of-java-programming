package task2;

public class NonPositiveIntegerException extends Exception {
    private static final long serialVersionUID = 3712552941739374213L;

    public NonPositiveIntegerException(int wrongValue) {
        super("Wrong numeric value: " + wrongValue + ". The numeric value must be positive.");
    }
}
