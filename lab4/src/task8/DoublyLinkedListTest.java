package task8;

/**
 * The {@link DoublyLinkedListTest} class that contains test scenarios for the {@link DoublyLinkedList} class.
 */
public class DoublyLinkedListTest {
    /**
     * Tests the functionality of the {@link DoublyLinkedList} class with the specified element data.
     * @param list the DoublyLinkedList to be tested;
     * @param elementData the element data to be used in the test.
     * @param <T> the type of elements stored in the list.
     */
    private static <T> void testFunctionality(DoublyLinkedList<T> list, T elementData) {
        System.out.println("Initial list:\n" + list + "\n");

        int index = 1;
        System.out.println("Add list item data \'" + elementData + "\' by index " + index + ": \t"
                + list.addByIndex(index, elementData));
        index = 3;
        System.out.println("Add list item data \'" + elementData + "\' by index " + index + ": \t"
                + list.addByIndex(index, elementData));
        index = -4;
        System.out.println("Add list item data \'" + elementData + "\' by index " + index + ": \t"
                + list.addByIndex(index, elementData));
        System.out.println("List after adding items:\n" + list + "\n");

        System.out.println("Remove first list item:\t\t\t" + list.removeFirst());
        System.out.println("Remove last list item:\t\t\t" + list.removeLast());
        index = 1;
        System.out.println("Remove list item by index " + index + ":\t" + list.removeAtIndex(index));
        System.out.println("List after removing items:\n" + list + "\n");

        System.out.println("Find list item index by data \'" + elementData + "\':\t"
                + list.indexOfData(elementData));
        System.out.println("Find list item index by data \'" + null + "\':\t"
                + list.indexOfData(null) + "\n");

        System.out.println("Remove the first occurrence of data \'" + elementData + "\' from the list:  \t"
                + list.removeFirstOccurrence(elementData));
        System.out.println("Remove the first occurrence of data \'" + null + "\' from the list:\t\t"
                + list.removeFirstOccurrence(null));
        System.out.println("List after removing items data:\n" + list + "\n");

        index = 1;
        System.out.println("Get list item data by index " + index + ":\t\t" + list.getDataByIndex(index));
        index = 28;
        System.out.print("Get list item data by index " + index + ":\t\t");
        System.out.println(list.getDataByIndex(index) + "\n");

        System.out.println("Clear all items from list:");
        list.clearList();
        System.out.println("List after cleaning items:\n" + list + "\n");
    }

    /**
     * Tests the {@link DoublyLinkedList} class with Integer elements.
     */
    private static void testIntegerList() {
        System.out.println("*******************************************************************************");
        System.out.println("Test the DoublyLinkedList class with type Integer:");
        System.out.println("*******************************************************************************");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(-1);
        list.addFirst(8);
        list.addFirst(12);
        list.addFirst(15);
        list.addLast(21);
        list.addLast(29);
        testFunctionality(list, 8);
    }

    /**
     * Tests the {@link DoublyLinkedList} class with String elements.
     */
    private static void testStringList() {
        System.out.println("*******************************************************************************");
        System.out.println("Test the DoublyLinkedList class with type String:");
        System.out.println("*******************************************************************************");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("Apple");
        list.addLast("Orange");
        list.addLast("Banana");
        list.addLast("Grape");
        list.addFirst("Plum");
        list.addFirst("Kiwi");
        testFunctionality(list, "Banana");
    }

    /**
     * Main method to execute the test scenarios for the {@link DoublyLinkedList} class.
     * @param args the command-line arguments (not used).
     */
    public static void main(String[] args) {
        testIntegerList();
        testStringList();
    }
}
