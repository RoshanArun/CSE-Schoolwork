package edu.ser222.m01_03;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CompletedList represents an implementation of a list.
 *
 * @author Roshan Arun, Acuna
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

    public T removeFirst() throws NoSuchElementException {
        if (count == 0) {
            throw new NoSuchElementException("");
        }

        DoubleLinearNode<T> result = head;
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        count = count - 1;
        return result.getItem();
    }

    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }

        DoubleLinearNode<T> current;

        tail = head;
        current = tail;

        while (tail.getNext() != null) {
            current = tail;
            tail = tail.getNext();
        }

        tail = current;
        current.next = null;

        return tail.getItem();
    }

    @Override
    public T remove(T element) {
        boolean found = false;
        DoubleLinearNode<T> previous = null;
        DoubleLinearNode<T> current = head;

        while (current != null && !found) {
            if (element.equals(current.getItem())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (found == false) {
            throw new NoSuchElementException();
        }

        if (element == null) {
            throw new NullPointerException();
        }

        if (current.equals(head)) {
            head = current.getNext();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        count = count - 1;

        return current.getItem();
    }

    @Override
    public boolean contains(T target) {
        boolean found = false;
        DoubleLinearNode<T> current = head;

        while (current != null && !found) {
            if (target.equals(current.getItem())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
        // TODO Auto-generated method stub

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public T first() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        return head.getItem();
    }

    public T last() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        return tail.getItem();
    }

    public String toString() {
        DoubleLinearNode<T> current = head;
        String result = "";

        while (current != null) {
            result = result + (current.getItem()).toString() + " ";
            current = current.getNext();
        }

        if (count == 0) {
            return "empty";
        }

        return result;
    }

    public class DoubleLinearNode<Item> {
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

        public void setPrev(DoubleLinearNode<Item> prev) {
            this.prev = prev;
        }
    }
}