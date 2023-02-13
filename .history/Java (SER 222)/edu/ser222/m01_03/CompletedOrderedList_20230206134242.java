package edu.ser222.m01_03;

/**
 * CompletedOrderedList represents an implementation of an ordered list that
 * builds
 * on
 * CompletedList.
 *
 * @author (your name), Acuna
 * @version (version)
 */
public class CompletedOrderedList<T extends Comparable<T>> extends CompletedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) throws NullPointerException {
        // if (element == null) {
        // throw new NullPointerException();
        // }

        // DoubleLinearNode<T> node = new DoubleLinearNode<T>(element);
        // DoubleLinearNode<T> current;

        // if (head == null || head.getItem().compareTo(node.getItem()) > 0) {
        // node.setNext(head);
        // head = node;
        // } else {
        // current = head;
        // while (current.getNext() != null &&
        // current.getNext().getItem().compareTo(node.getItem()) < 0) {
        // current = current.getNext();
        // }
        // node.setNext(current.getNext());
        // current.setNext(node);
        // }

        // count = count + 1;

        // Create a new node with the given element
        DoubleLinearNode<T> newNode = new DoubleLinearNode<T>(element);

        // Sets the head and tail if the list is empty
        if (count == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // Check if the element is greater than the head and less than the tail
            if (element.compareTo(head.getItem()) > 0 && element.compareTo(tail.getItem()) < 0) {
                // Find the correct position to insert the new node
                DoubleLinearNode<T> current = head;

                while (current != null) {
                    // Check if the element is between the current node's element and the next
                    // node's element
                    if (element.compareTo(current.getItem()) > 0
                            && element.compareTo(current.getNext().getItem()) < 0) {
                        // Inserts the new node between the current node and the next node
                        newNode.setPrev(current);
                        newNode.setNext(current.getNext());
                        current.getNext().setPrev(newNode);
                        current.setNext(newNode);
                        break;
                    } else {
                        current = current.getNext();
                    }
                }
            }

            // Check if the element is greater than the tail
            else if (element.compareTo(tail.getItem()) > 0) {
                // Insert the new node at the end of the list
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
            }

            // Check if the element is less than the head
            else if (element.compareTo(head.getItem()) < 0) {
                // Insert the new node at the beginning of the list
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
        }
        // Increment the list size
        count++;
    }
    // TODO: implement this!
}