package edu.ser222.m01_03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

/**
 * CompletedList represents an implementation of a list.
 *
 * @author (your name), Acuna
 * @version (version)
 */
public class CompletedList<T> implements ListADT<T>, Iterable<T> {
    // The following three variables are a suggested start if you are using a list
    // implementation.
    protected int count;
    protected int modChange;
    protected DoubleLinearNode<T> head, tail;
    // TODO: implement this!

    public CompletedList() {
        count = 0;
        head = null;
        tail = null;
    }

    private class DoubleLinearNode<Item> {
        private Item item;
        private DoubleLinearNode next;
        private DoubleLinearNode prev;

        public DoubleLinearNode(Item item) {
            this.item = item;
            prev = null;
            next = null;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public DoubleLinearNode<Item> getPrev() {
            return prev;
        }

        public void DoubleLinearNode(DoubleLinearNode<Item> prev) {
            this.prev = prev;
        }

        public DoubleLinearNode<Item> getNext() {
            return next;
        }

        public void setNext(DoubleLinearNode<Item> next) {
            this.next = next;
        }
    }

    public T removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }

        DoubleLinearNode<T> result = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }

        count = count - 1;
        return result.getItem();
    }
}