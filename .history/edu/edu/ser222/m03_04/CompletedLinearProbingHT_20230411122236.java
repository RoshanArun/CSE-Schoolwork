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
    private Object[] entries;
    private int size;

    public CompletedLinearProbingHT() {
        this(997);
    }

    public CompletedLinearProbingHT(int m) {
        M = m;
        entries = new Object[M];
        size = 0;
    }

    @Override
    public int hash(Key key, int i) {
        return ((key.hashCode() & 0x7fffffff) + i) % M;
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) {
            return;
        }
        if (val == null) {
            delete(key);
            return;
        }
        int i = 0;
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {
                entries[h] = new Entry<Key, Value>(key, val);
                size++;
                break;
            }
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                ((Entry<Key, Value>) entries[h]).val = val;
                break;
            }
            i++;
        }
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        int i = 0;
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {
                break;
            }
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                return ((Entry<Key, Value>) entries[h]).val;
            }
            i++;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null) {
            return;
        }
        int i = 0;
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {
                break;
            }
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                entries[h] = null;
                size--;
                break;
            }
            i++;
        }
        i++;
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {
                break;
            }
            Entry<Key, Value> entry = (Entry<Key, Value>) entries[h];
            entries[h] = null;
            size--;
            put(entry.key, entry.val);
            i++;
        }
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) {
            return false;
        }
        int i = 0;
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {
                break;
            }
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                return true;
            }
            i++;
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
        for (int i = 0; i < M; i++)
            if (entries[i] != null)
                queue.add(((Entry<Key, Value>) entries[i]).key);
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

    private static class Entry<Key, Value> {
        Key key;
        Value val;

        public Entry(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}