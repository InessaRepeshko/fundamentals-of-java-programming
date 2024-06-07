package task4;

import java.util.List;
import java.util.Optional;

public class NumberListOperations {
    private NumberListOperations() {}

    public static <T extends Number> int findIndexOfFirstZeroNumber(List<T> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i).doubleValue() == 0.0) {
                return i;
            }
        }

        return -1;
    }

    public static <T extends Number> int findCountOfNegativeNumbers(List<T> numberList) {
        int countOfNegativeNumbers = 0;

        for (T number : numberList) {
            if (number.doubleValue() < 0.0) {
                countOfNegativeNumbers++;
            }
        }

        return countOfNegativeNumbers;
    }

    public static <T extends Number> Optional<T> getLastNegativeNumber(List<T> numberList) {
        T lastNegativeNumber = null;

        for (T number : numberList) {
            if (number.doubleValue() < 0.0) {
                lastNegativeNumber = number;
            }
        }

        return Optional.ofNullable(lastNegativeNumber);
    }
}
