
package edu.ser222.m02_02;

/**
 * Implements various divide and conquer algorithms.
 *
 * Last updated 4/2/2022.
 *
 * Completion time: (your completion time)
 *
 * @author (your name), Acuna, Sedgewick and Wayne
 * @verison (version)
 */
import java.util.Random;

public class CompletedMerging implements MergingAlgorithms {

    // TODO: implement interface methods.
    @Override
    public <T extends Comparable> Queue<T> mergeQueues(Queue<T> q1, Queue<T> q2) {
        Queue<T> result = new ListQueue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            T e1 = q1.peek();
            T e2 = q2.peek();
            if (e1.compareTo(e2) < 0) {
                result.enqueue(q1.dequeue());
            } else {
                result.enqueue(q2.dequeue());
            }
        }
        while (!q1.isEmpty()) {
            result.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }
        return result;
    }

    @Override
    public void sort(Comparable[] a) {
        Comparable[] sorted = mergesort(a);
        for (int i = 0; i < a.length; i++) {
            a[i] = sorted[i];
        }
    }

    public Comparable[] mergesort(Comparable[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[a.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        left = mergesort(left);
        right = mergesort(right);
        return merge(left, right);
    }

    public Comparable[] merge(Comparable[] a, Comparable[] b) {
        int aSize = a.length;
        int bSize = b.length;
        int resultSize = aSize + bSize;
        Comparable[] result = new Comparable[resultSize];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < resultSize; i++) {
            if (aIndex < aSize && (bIndex >= bSize ||
                    a[aIndex].compareTo(b[bIndex]) <= 0)) {
                result[i] = a[aIndex];
                aIndex++;
            } else {
                result[i] = b[bIndex];
                bIndex++;
            }
        }
        return result;
    }

    @Override
    public void shuffle(Object[] a) {
        if (a.length <= 1) {
            return;
        }
        int mid = a.length / 2;
        Object[] left = new Object[mid];
        Object[] right = new Object[a.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        shuffle(left);
        shuffle(right);
        Object[] merged = mergeShuffle(left, right);
        for (int i = 0; i < a.length; i++) {
            a[i] = merged[i];
        }
    }

    private Object[] mergeShuffle(Object[] a, Object[] b) {
        Object[] result = new Object[a.length + b.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < a.length && j < b.length) {
            if (Math.random() < 0.5) {
                result[index] = a[i];
                i++;
            } else {
                result[index] = b[j];
                j++;
            }
            index++;
        }
        while (i < a.length) {
            result[index] = a[i];
            i++;
            index++;
        }
        while (j < b.length) {
            result[index] = b[j];
            j++;
            index++;
        }
        return result;
    }

    /**
     * entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> q1 = new ListQueue<>();
        q1.enqueue("E");
        q1.enqueue("L");
        q1.enqueue("O");
        q1.enqueue("R");
        q1.enqueue("T");
        Queue<String> q2 = new ListQueue<>();
        q2.enqueue("A");
        q2.enqueue("E");
        q2.enqueue("M");
        q2.enqueue("P");
        q2.enqueue("S");
        q2.enqueue("X");
        Queue<Integer> q3 = new ListQueue<>();
        q3.enqueue(5);
        q3.enqueue(12);
        q3.enqueue(15);
        q3.enqueue(17);
        q3.enqueue(20);
        Queue<Integer> q4 = new ListQueue<>();
        q4.enqueue(1);
        q4.enqueue(4);
        q4.enqueue(12);
        q4.enqueue(13);
        q4.enqueue(16);
        q4.enqueue(18);

        MergingAlgorithms ma = new CompletedMerging();

        // Q1 - sample test cases
        Queue merged1 = ma.mergeQueues(q1, q2);
        System.out.println(merged1.toString());
        Queue merged2 = ma.mergeQueues(q3, q4);
        System.out.println(merged2.toString());

        // Q2 - sample test cases
        String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        ma.sort(a);
        assert isSorted(a);
        show(a);

        // Q3 - sample test cases
        String[] b = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        ma.shuffle(b);
        show(b);

        ma.shuffle(b);
        show(b);
    }

    // below are utilities functions, please do not change them.

    // sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }

    // sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }
}