package task7;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * The {@link OneDimBoundedArray} is a class that represents a one-dimensional bounded array.
 * It extends AbstractList to provide a limited range of indexes for array elements.
 * @param <T> the type of elements stored in the array.
 */
public class OneDimBoundedArray<T> extends AbstractList<T> {
    /** The underlying array storing elements. */
    private final T[] array;

    /** The starting index of the bounded array. */
    private final int from;

    /** The ending index of the bounded array. */
    private final int to;

    /**
     * Constructs a OneDimBoundedArray with specified range and array.
     * @param from the start index of the array;
     * @param to the end index of the array;
     * @param array the array of elements.
     */
    public OneDimBoundedArray(int from, int to, T[] array) {
        if (from > to) {
            System.err.println("Incorrect element indexes.\n"
                    + "The \'from\' index must be less than or equal to the \'to\' index.");
            System.exit(1);
        }

        if ((to - from + 1) != array.length) {
            System.err.println("Incorrect element indexes and/or array length.\n"
                    + "The length of the array must be equal to the number of array element indexes plus one.");
            System.exit(1);
        }

        this.from = from;
        this.to = to;
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * Gets the start index of the array.
     * @return the start index of the array.
     */
    public int getFromIndex() {
        return from;
    }

    /**
     * Gets the end index of the array.
     * @return the end index of the array.
     */
    public int getToIndex() {
        return to;
    }

    /**
     * Verifies if the given index is valid for accessing elements in the array.
     * @param index the index to be verified;
     * @return {@code true} if the index is valid, {@code false} otherwise.
     */
    private boolean verifyIndex(int index) {
        return index >= from && index <= to;
    }

    /**
     * Gets the element at the specified index in the array.
     * @param index the index of the element to be retrieved.
     * @return the element at the specified index, or {@code null} if the index is invalid.
     */
    @Override
    public T get(int index) {
        if (!verifyIndex(index)) {
            System.out.print("Error: invalid index. ");

            return null;
        }

        return array[index - from];
    }

    /**
     * Returns the size of the array.
     * @return the size of the array.
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * Sets the element at the specified index in the array.
     * @param index the index of the element to be set;
     * @param element the new value for the element.
     * @return the previous value of the element, or {@code null} if the index is invalid.
     */
    @Override
    public T set(int index, T element) {
        if (!verifyIndex(index)) {
            System.out.print("Error: invalid index. ");

            return null;
        }

        T oldValue = array[index - from];
        array[index - from] = element;

        return oldValue;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the array.
     * @param obj the element to find in the array.
     * @return the index of the first occurrence, or {@code -1} if not found.
     */
    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if ((obj == null
                    && array[i] == null)
                    || (obj != null
                        && obj.equals(array[i]))) {
                return i + from;
            }
        }

        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in the array.
     * @param obj the element to find in the array.
     * @return the index of the last occurrence, or {@code -1} if not found.
     */
    @Override
    public int lastIndexOf(Object obj) {
        for (int i = array.length - 1; i >= 0; i--) {
            if ((obj == null
                    && array[i] == null)
                    || (obj != null
                        && obj.equals(array[i]))) {
                return i + from;
            }
        }

        return -1;
    }

    /**
     * Iterator for traversing the elements of the array.
     */
    private class OneDimBoundedArrayIterator implements Iterator<T> {
        /** The current position of the iterator within the bounded array. */
        private int cursor = from;

        /**
         * Checks if there is another element in the array to iterate.
         * @return {@code true} if there is another element, {@code false} otherwise.
         */
        @Override
        public boolean hasNext() {
            return cursor <= to;
        }

        /**
         * Retrieves the next element in the array.
         * @return the next element in the array.
         */
        @Override
        public T next() {
            return array[cursor++ - from];
        }
    }

    /**
     * Returns an iterator over the elements of the array.
     * @return an iterator over the elements of the array.
     */
    @Override
    public Iterator<T> iterator() {
        return new OneDimBoundedArrayIterator();
    }

    /**
     * Returns a string representation of the array with index range information.
     * @return a string representation of the array.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\tfrom = " + getFromIndex() + "\tto = "
                + getToIndex() + ":\nElements:\t[");

        for (T data : this) {
            result.append(data);
            result.append(", ");
        }

        result.replace(result.length() - 2, result.length(), "]");

        return result.toString();
    }

    /**
     * Tests the {@code OneDimBoundedArray} functionality with Integer elements.
     */
    private static void testCreateIntegerArray() {
        OneDimBoundedArray<Integer> arrayOfIntegers = new OneDimBoundedArray<>(5, 7, new Integer[]{2, 7, 9});
        System.out.println("Initial array of Integers with indexes" + arrayOfIntegers + "\n");

        int index = 0;
        System.out.println("Verify that the element index " + index + " exists in the array:\t"
                + arrayOfIntegers.verifyIndex(index));
        index = 7;
        System.out.println("Verify that the element index " + index + " exists in the array:\t"
                + arrayOfIntegers.verifyIndex(index));
    }

    /**
     * Main method to execute the test for creating a OneDimBoundedArray with Integer elements.
     * @param args the command-line arguments (not used).
     */
    public static void main(String[] args) {
        testCreateIntegerArray();
    }
}
