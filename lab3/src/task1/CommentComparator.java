package task1;

import java.util.Comparator;

/**
 * The class that implements the Comparator interface for sorting hours by descending comment length.
 * This class implements the {@code Comparator} interface for objects of type {@code Hour}.
 */
public class CommentComparator implements Comparator<Hour> {
    /**
     * Compares two hours based on comment length.
     * @param firstHour the first hour to compare;
     * @param secondHour the second hour to compare.
     * @return negative number, if {@code secondHour} length is larger than {@code firstHour},
     * zero, if their length are equal, positive number, if {@code secondHour} length is smaller than {@code firstHour}.
     */
    @Override
    public int compare(Hour firstHour, Hour secondHour) {
        return Integer.compare(secondHour.getCommentLength(), firstHour.getCommentLength());
    }
}
