
package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with linear probing.
 * 
 * @author (put your name here), Sedgewick and Wayne, Acuna
 */
import java.util.LinkedList;
import java.util.Queue;

public class CompletedLinearProbingHT<Key, Value> implements ProbingHT<Key, Value> {

    // any constructors must be made public
    private int M;
    private int size;
    private Object[] entries;

    public CompletedLinearProbingHT() {
        this.M = 997;
        this.size = 0;
        this.entries = new Object[M];
    }

    @Override
    public int hash(Key key, int i) {
        return ((key.hashCode() & 0x7fffffff) + i) % M;
    }

    @Override
    public void put(Key key, Value val) {
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null) {
            i++;
            hash = hash(key, i);
        }
        entries[hash] = new Entry<Key, Value>(key, val);
        size++;
    }

    @Override
    public Value get(Key key) {
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null) {
            Entry entry = (Entry) entries[hash];
            if (entry.getKey().equals(key)) {
                return (Value) entry.getValue();
            }
            i++;
            hash = hash(key, i);
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null) {
            Entry entry = (Entry) entries[hash];
            if (entry.getKey().equals(key)) {
                entries[hash] = null;
                size--;
            }
            i++;
            hash = hash(key, i);
        }
    }

    @Override
    public boolean contains(Key key) {
        int i = 0;
        int hash = hash(key, i);
        while (entries[hash] != null) {
            Entry entry = (Entry) entries[hash];
            if (entry.getKey().equals(key)) {
                return true;
            }
            i++;
            hash = hash(key, i);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (entries[i] != null) {
                Entry entry = (Entry) entries[i];
                queue.add((Key) entry.getKey());
            }
        }
        return queue;
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