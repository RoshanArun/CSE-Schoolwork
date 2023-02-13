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
        } else {
            current = head;
            while (current.getNext() != null && current.getNext().getItem().compareTo(node.getItem()) < 0) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }

        DoubleLinearNode<T> current2 = head;
        tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        // while (current2.getNext() != null) {
        // if (current2.getNext().getNext() == null) {
        // tail.setPrev(current2);
        // } else {
        // current2 = current2.getNext();
        // }
        // }

        count = count + 1;
    }
    // TODO: implement this!
}