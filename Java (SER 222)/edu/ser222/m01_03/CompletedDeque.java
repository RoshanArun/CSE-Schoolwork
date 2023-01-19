package edu.ser222.m01_03;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;

/**
 * This program provides an implementation of the Deque interface. Also provides
 * a main that
 * demonstrates it.
 * 
 * @author (Roshan Arun), Acuna
 * @version (version)
 */

public class CompletedDeque<Item> implements Deque<Item> {

    private Node head;
    private Node tail;
    private int size;

    // TODO: implement all the methods
    public CompletedDeque() {
        tail = null;
        head = null;
        size = 0;
    }

    public void enqueueFront(Item element) {

    }

    public void enqueueBack(Item element) {

    }

    public Item dequeueFront() {
        throw new NoSuchElementException();
    }

    public Item dequeueBack() {
        throw new NoSuchElementException();
    }

    public Item first() {
        throw new NoSuchElementException();
    }

    public Item last() {
        throw new NoSuchElementException();
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
        return "test";
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

        // deque features
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