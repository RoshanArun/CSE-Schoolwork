package edu.ser222.m02_01;

import java.util.Random;

/**
 * (basic description of the program or class)
 * 
 * Completion time: (estimation of hours spent on this program)
 *
 * @author (your name), Acuna, Sedgewick
 * @version (a version number or a date)
 */
public class CompletedBenchmarkTool implements BenchmarkTool {

    /***************************************************************************
     * START - SORTING UTILITIES, DO NOT MODIFY (FROM SEDGEWICK) *
     **************************************************************************/

    public static void insertionSort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void shellsort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3)
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public Integer[] generateTestDataBinary(int size) {
        int z = 0;
        int o = 1;

        Integer zero = z;
        Integer one = o;
        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            if (i <= arr.length / 2 - 1) {
                arr[i] = zero;
            } else {
                arr[i] = one;
            }
        }

        return arr;
    }

    public Integer[] generateTestDataHalves(int size) {

    }

    public Integer[] generateTestDataHalfRandom(int size) {
        int z = 0;
        Integer zero = z;

        Integer[] arr = new Integer[size];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            if (i <= arr.length / 2 - 1) {
                arr[i] = zero;
            } else {
                arr[i] = r.nextInt(Integer.MAX_VALUE);
            }
        }

        return arr;

    }

    public double computeDoublingFormula(double t1, double t2) {

    }

    public double benchmarkInsertionSort(Integer[] small, Integer[] large) {

    }

    public double benchmarkShellsort(Integer[] small, Integer[] large) {

    }

    public void runBenchmarks(int size) {

    }

    /***************************************************************************
     * END - SORTING UTILITIES, DO NOT MODIFY *
     **************************************************************************/
    // TODO: implement interface methods.
    public static void main(String args[]) {
        BenchmarkTool me = new CompletedBenchmarkTool();
        int size = 4096;

        // NOTE: feel free to change size here. all other code must go in the
        // methods.

        me.runBenchmarks(size);
    }
}