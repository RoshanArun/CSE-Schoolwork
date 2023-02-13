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
        System.out.println(node.getItem());

        if (count == 0) {
            head = node;
            tail = node;
        } else if (element.compareTo(node.getItem()) > 0) {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        count = count + 1;
    }
    // TODO: implement this!
}