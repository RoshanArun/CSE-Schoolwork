package edu.ser222.m03_04;

/*
 * A symbol table implemented using a hashtable with linear probing.
 * 
 * @author (put your name here), Sedgewick and Wayne, Acuna
 */
import java.util.LinkedList;
import java.util.Queue;

public class CompletedLinearProbingHT<Key, Value> implements ProbingHT<Key, Value> {

    private int M; // size of table
    private Object[] entries; // array of values

    // any constructors must be made public
    public CompletedLinearProbingHT() {
        this.M = 997;
        this.entries = new Object[M];
    }

    @Override
    public int hash(Key key, int i) {
        return (key.hashCode() & 0x7ffffff) + i;
    }

    @Override
    public void put(Key key, Value val) {
        int hash = hash(key, 0);
        int i = 0;
        while (entries[hash] != null) {
            i++;
            hash = hash(key, i);
        }
        entries[hash] = val;
    }

    @Override
    public Value get(Key key) {
        int hash = hash(key, 0);
        int i = 0;
        while (entries[hash] != null) {
            if (entries[hash].equals(key)) {
                return (Value) entries[hash];
            }
            i++;
            hash = hash(key, i);
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        int hash = hash(key, 0);
        int i = 0;
        while (entries[hash] != null) {
            // if found the key
            if (entries[hash].equals(key)) {
                // shift the subsequent entries up one index
                for (int j = hash; j < M - 1; j++) {
                    entries[j] = entries[j + 1];
                }
            }
            i++;
            hash = hash(key, i);
        }
    }

    @Override
    public boolean contains(Key key) {
        int hash = hash(key, 0);
        int i = 0;
        while (entries[hash] != null) {
            if (entries[hash].equals(key)) {
                return true;
            }
            i++;
            hash = hash(key, i);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object o : entries) {
            if (o != null)
                count++;
        }
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (Object o : entries) {
            if (o != null) {
                q.add((Key) o);
            }
        }
        return q;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // THESE METHODS ARE ONLY FOR GRADING AND COME FROM THE PROBINGHT INTERFACE.

    @Override
    public int getM() {
        return M;
    }

    @Override
    public Object getTableEntry(int i) {
        return entries[i];
    }
}