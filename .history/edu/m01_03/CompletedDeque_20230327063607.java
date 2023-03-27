package m01_03;

import java.util.NoSuchElementException;

/**
 * This program provides an implementation of the Deque interface. Also provides
 * a main that
 * demonstrates it.
 * 
 * @author (Roshan Arun), Acuna
 * @version (version)
 */

public class CompletedDeque<Item> implements Deque<Item> {

    private class Node<Item> {
        private Item item;
        private Node next;
        private Node prev;

        public Node(Item item) {
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

        public Node<Item> getPrev() {
            return prev;
        }

        public void setPrev(Node<Item> prev) {
            this.prev = prev;
        }

        public Node<Item> getNext() {
            return next;
        }

        public void setNext(Node<Item> next) {
            this.next = next;
        }
    }

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public CompletedDeque() {
        tail = null;
        head = null;
        size = 0;
    }

    public void enqueueFront(Item element) {
        Node<Item> node = new Node<Item>(element);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size = size + 1;
    }

    public void enqueueBack(Item element) {
        Node<Item> node = new Node<Item>(element);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size = size + 1;
    }

    public Item dequeueFront() {
        if (head == null) {
            throw new NoSuchElementException("empty");
        }

        Item item = head.getItem();
        head = head.getNext();

        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        size = size - 1;
        return item;
    }

    public Item dequeueBack() {
        if (tail == null) {
            throw new NoSuchElementException("empty");
        }

        Item item = tail.getItem();
        tail = tail.getPrev();

        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size = size - 1;
        return item;
    }

    public Item first() {
        if (head == null) {
            throw new NoSuchElementException("empty");
        }

        Item item = head.getItem();
        return item;
    }

    public Item last() {
        if (tail == null) {
            throw new NoSuchElementException("empty");
        }

        Item item = tail.getItem();
        return item;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }

        String end = "";
        Node<Item> current = tail;
        while (current != null) {
            end = end + current.getItem() + " ";
            current = current.getPrev();
        }
        return end;
    }

    /**
     * Program entry point for deque.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        CompletedDeque<Integer> deque = new CompletedDeque<>();

        // standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        // // deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }
}