package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with linear probing.
 * 
 * @author (put your name here), Sedgewick and Wayne, Acuna
 */
import java.util.LinkedList;
import java.util.Queue;

public class CompletedLinearProbingHT<Key, Value> implements ProbingHT<Key, Value> {
    private int M;
    private int size;
    private Object[] entries;

    /**
     * A constructor that defaults to an array of size 997.
     */
    public CompletedLinearProbingHT() {
        M = 997;
        size = 0;
        entries = new Object[M];
    }

    @Override
    public int hash(Key key, int i) {
        // TODO
        return ((key.hashCode() & 0x7fffffff) + i) % M;
    }

    @Override
    public void put(Key key, Value val) {
        // TODO
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null && !entries[hash].equals(key)) {
            i++;
            hash = hash(key, i);
        }
        entries[hash] = key;
        size++;
    }

    @Override
    public Value get(Key key) {
        // TODO
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null && !entries[hash].equals(key)) {
            i++;
            hash = hash(key, i);
        }
        if (entries[hash] == null) {
            return null;
        }
        return (Value) entries[hash];
    }

    @Override
    public void delete(Key key) {
        // TODO
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null && !entries[hash].equals(key)) {
            i++;
            hash = hash(key, i);
        }
        if (entries[hash] == null) {
            return;
        }
        entries[hash] = null;
        size--;

        // rehash all keys in same cluster
        i++;
        while (entries[hash(key, i)] != null) {
            Key keyToRehash = (Key) entries[hash(key, i)];
            entries[hash(key, i)] = null;
            size--;
            put(keyToRehash, (Value) keyToRehash);
            i++;
        }
    }

    @Override
    public boolean contains(Key key) {
        // TODO
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null && !entries[hash].equals(key)) {
            i++;
            hash = hash(key, i);
        }
        if (entries[hash] == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    @Override
    public int size() {
        // TODO
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO
        Queue<Key> q = new LinkedList<>();
        for (Object e : entries) {
            if (e != null) {
                q.add((Key) e);
            }
        }
        return q;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // THESE METHODS ARE ONLY FOR GRADING AND COME FROM THE PROBINGHT INTERFACE.

    @Override
    public int getM() {
        // TODO. We suggest something like:
        // return M;

        return M;
    }

    @Override
    public Object getTableEntry(int i) {
        // TODO. We suggest something like:
        // return entries[i];

        return entries[i];
    }
}