package edu.ser222.m01_03;

import java.util.Iterator;

/**
 * CompletedOrderedList testing area.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class Driver {
    public static void main(String[] args) {
        OrderedListADT<Integer> list = new CompletedOrderedList<>();

        // RA: These are _extremely_ simple tests! You will need to write more!

        list.add(23);
        list.add(24);
        list.add(16);

        System.out.println(list);

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        // display using toString()
        System.out.println(list);

        /*
         * Test Results:
         * 1 3 7 9 13 14 16 17 23 24
         * 3 9 13 16
         */
        // display using automatic iterator way
        // for (Integer x : list) {
        // System.out.print(x + " ");
        // }
        // System.out.println();
        // // display using manual iterator way
        // Iterator iter = list.iterator();
        // while (iter.hasNext()) {
        // System.out.print(iter.next());
        // if (iter.hasNext())
        // System.out.print(" ");
        // }
        // toString is probably the nicest if we just need to display.
        // You should definitely write a test for ConcurrentModificationException...
    }
}
