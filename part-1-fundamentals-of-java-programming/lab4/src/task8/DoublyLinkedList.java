package task8;

import java.util.Iterator;

/**
 * The {@link DoublyLinkedList} represents a generic doubly linked list.
 * @param <E> the type of elements stored in the list.
 */
public class DoublyLinkedList<E> implements Iterable<E> {
    /**
     * Node represents a node in the doubly linked list.
     * @param <E> the type of elements stored in the node.
     */
    private static class Node<E> {
        /** The data stored in the node. */
        E data;

        /** The reference to the next node in the list. */
        Node<E> next;

        /** The reference to the previous node in the list. */
        Node<E> previous;

        /**
         * Constructor for creating a new node with the specified previous, element, and next nodes.
         * @param previous the previous node in the list;
         * @param element the data of the node;
         * @param next the next node in the list.
         */
        Node(Node<E> previous, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.previous = previous;
        }
    }

    /** Field representing the first node of the list. */
    private Node<E> first = null;

    /** Field representing the last node of the list. */
    private Node<E> last = null;

    /** Field representing the size of the list. */
    private int size = 0;

    /**
     * Adds an element to the beginning of the list.
     * @param element the element to be added.
     */
    public void addFirst(E element) {
        Node<E> linkToFirst = first;
        Node<E> newNode = new Node<>(null, element, first);
        first = newNode;

        if (linkToFirst == null) {
            last = newNode;
        } else {
            linkToFirst.previous = newNode;
        }

        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to be added.
     */
    public void addLast(E element) {
        Node<E> linkToLast = last;
        Node<E> newNode = new Node<>(linkToLast, element, null);
        last = newNode;

        if (linkToLast == null) {
            first = newNode;
        } else {
            linkToLast.next = newNode;
        }

        size++;
    }

    /**
     * Verifies if the given index is valid for accessing elements in the list.
     * @param index the index to be verified;
     * @return {@code true} if the index is valid, {@code false} otherwise.
     */
    private boolean verifyIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Finds and returns the node at the specified index in the list.
     * @param index the index of the node to be found;
     * @return the node at the specified index.
     */
    private Node<E> findByIndex(int index) {
        Node<E> current;

        if (index < (size >> 1)) {
            current = first;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        } else {
            current = last;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }

            return current;
        }
    }

    /**
     * Adds an element at the specified index in the list.
     * @param index the index at which the element will be added;
     * @param element the element to be added to the list.
     * @return {@code true} if the element is added successfully, {@code false} otherwise.
     */
    public boolean addByIndex(int index, E element) {
        if (index == size) {
            addLast(element);

            return true;
        }

        if (!verifyIndex(index)) {
            return false;
        }

        Node<E> current = findByIndex(index);
        Node<E> prevCurrent = current.previous;
        Node<E> newNode = new Node<>(prevCurrent, element, current);
        current.previous = newNode;

        if (prevCurrent == null) {
            first = newNode;
        } else {
            prevCurrent.next = newNode;
        }

        size++;

        return true;
    }

    /**
     * Removes and returns the first element in the list.
     * @return the first element in the list, or {@code null} if the list is empty.
     */
    public E removeFirst() {
        Node<E> linkToFirst = first;

        if (linkToFirst == null) {
            System.out.println("The list is empty.");

            return null;
        }

        E element = linkToFirst.data;
        Node<E> next = linkToFirst.next;
        linkToFirst.data = null;
        linkToFirst.next = null;
        first = next;

        if (next == null) {
            last = null;
        } else {
            next.previous = null;
        }

        size--;

        return element;
    }

    /**
     * Removes and returns the last element in the list.
     * @return the last element in the list, or {@code null} if the list is empty.
     */
    public E removeLast() {
        Node<E> linkToLast = last;

        if (linkToLast == null) {
            System.out.println("The list is empty.");

            return null;
        }

        E element = linkToLast.data;
        Node<E> prev = linkToLast.previous;
        linkToLast.data = null;
        linkToLast.previous = null;
        last = prev;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;

        return element;
    }

    /**
     * Removes the specified node from the list.
     * @param current the node to be removed.
     */
    private void remove(Node<E> current) {
        Node<E> next = current.next;
        Node<E> prev = current.previous;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            current.previous = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previous = prev;
            current.next = null;
        }

        current.data = null;
        size--;
    }

    /**
     * Removes and returns the element at the specified index in the list.
     * @param index the index of the element to be removed.
     * @return the removed element, or {@code null} if the index is invalid.
     */
    public E removeAtIndex(int index) {
        if (!verifyIndex(index)) {
            System.out.print("Error: invalid index. ");

            return null;
        }

        Node<E> current = findByIndex(index);
        E element = current.data;
        remove(current);

        return element;
    }

    /**
     * Finds the index of the first occurrence of the specified element in the list.
     * @param element the element to find in the list.
     * @return the index of the first occurrence, or {@code -1} if not found.
     */
    public int indexOfData(E element) {
        int index = 0;

        if (element == null) {
            for (Node<E> i = first; i != null; i = i.next) {
                if (i.data == null) {
                    return index;
                }

                index++;
            }
        } else {
            for (Node<E> i = first; i != null; i = i.next) {
                if (element.equals(i.data)) {
                    return index;
                }

                index++;
            }
        }

        return -1;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     * @param element the element to be removed.
     * @return {@code true} if the element is removed successfully, {@code false} otherwise.
     */
    public boolean removeFirstOccurrence(E element) {
        int index = indexOfData(element);

        if (index >= 0) {
            Node<E> current = findByIndex(index);
            remove(current);

            return true;
        }

        return false;
    }

    /**
     * Gets the size of the list.
     * @return the size of the list.
     */
    public int listSize() {
        return size;
    }

    /**
     * Gets the data of the element at the specified index in the list.
     * @param index the index of the element.
     * @return the data of the element, or {@code null} if the index is invalid.
     */
    public E getDataByIndex(int index) {
        if (!verifyIndex(index)) {
            System.out.print("Error: invalid index. ");

            return null;
        }

        return findByIndex(index).data;
    }

    /**
     * Clears the list by removing all elements and resetting size to 0.
     */
    public void clearList() {
        for (Node<E> i = first; i != null; ) {
            Node<E> next = i.next;
            i.data = null;
            i.next = null;
            i.previous = null;
            i = next;
        }

        first = last = null;
        size = 0;
    }

    /**
     * Iterator for traversing the elements of the list.
     */
    private class DoublyLinkedListIterator implements Iterator<E> {
        /** The current node in the iteration.
         */
        private Node<E> current = first;

        /**
         * Checks if there is a next element in the iteration.
         * @return true if there is a next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element.
         */
        @Override
        public E next() {
            E data = current.data;
            current = current.next;

            return data;
        }
    }

    /**
     * Returns an iterator over the elements of the list.
     * @return an iterator over the elements of the list.
     */
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    /**
     * Provides the string representing of the list.
     * @return a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("List size:\t" + listSize() + "\n");

        if (listSize() > 0) {
            result.append("Elements:\t[");

            for (E data : this) {
                result.append(data);
                result.append(", ");
            }

            result.replace(result.length() - 2, result.length(), "]");
        } else {
            result.append("List is empty.\n");
        }

        return result.toString();
    }

    /**
     * Perform testing the {@code DoublyLinkedList} functionality with Integer elements.
     */
    private static void testCreateIntegerList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(18);
        list.addLast(25);
        list.addLast(37);
        list.addLast(5);
        list.addFirst(1);

        System.out.println("Initial list of Integers:\n" + list + "\n");

        int index = 1;
        System.out.println("Remove an element from the list at index " + index + ":\t");
        list.remove(list.findByIndex(index));
        System.out.println(list);
        System.out.println();

        System.out.println("Verify that the element at index " + index + " exists in the list:\t"
                + list.verifyIndex(index));
        index = 7;
        System.out.println("Verify that the element at index " + index + " exists in the list:\t"
                + list.verifyIndex(index));
    }

    /**
     * Main method to execute the test for creating a {@code DoublyLinkedList} with Integer elements.
     * @param args the command-line arguments (not used).
     */
    public static void main(String[] args) {
        testCreateIntegerList();
    }
}
