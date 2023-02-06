package edu.ser222.m01_03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

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
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }

        DoubleLinearNode<T> result = head;
        head = head.getNext();
        head.prev = null;
        count = count - 1;
        return result.getItem();
    }

    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }

        DoubleLinearNode<T> result = tail;
        tail = result.getPrev();
        tail.next = null;
        count = count - 1;
        return result.getItem();
    }

    @Override
    public T remove(T element) {
        boolean isTrue = false;
        DoubleLinearNode<T> previous = null;
        DoubleLinearNode<T> current = head;

        while (current != null && isTrue == false) {
            if (element.equals(current.getItem())) {
                isTrue = true;
            } else {
                previous = current;
                ;
                current = head.getNext();
            }
        }

        if (isTrue == false) {
            throw new NoSuchElementException();
        }

        if (size() == 1)
            head = tail = null;
        else if (current.equals(head))
            head = current.getNext();
        else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else
            previous.setNext(current.getNext());

        count--;
        return current.getItem();

    }

    @Override
    public boolean contains(T target) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
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
        return head.getItem();
    }

    public T last() {
        return tail.getItem();
    }

    public String toString() {
        DoubleLinearNode<T> current = head;
        String result = "";

        while (current != null) {
            result = result + (current.getItem()).toString() + "\n";
            current = current.getNext();
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