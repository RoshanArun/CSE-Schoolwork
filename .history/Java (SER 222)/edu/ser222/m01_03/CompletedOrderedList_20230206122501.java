package edu.ser222.m01_03;

import java.util.Iterator;

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
    private DoubleLinearNode<T> list;

    @Override
    public void add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }

        DoubleLinearNode<T> node = new DoubleLinearNode<T>(element);
        DoubleLinearNode<T> current;

        if (head == null || head.getItem().compareTo(node.getItem()) > 0) {
            node.setNext(head);
            head = node;
            tail = node;
        } else {
            current = head;
            while (current.getNext() != null && current.getNext().getItem().compareTo(node.getItem()) < 0) {
                current = current.getNext();
                tail = current;
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }

        // tail = head;
        // DoubleLinearNode<T> current2;

        // while (tail.getNext() != null) {
        // current2 = tail;
        // tail.setPrev(current2);

        // tail = tail.getNext();
        // }

        count = count + 1;
    }
    // TODO: implement this!
}