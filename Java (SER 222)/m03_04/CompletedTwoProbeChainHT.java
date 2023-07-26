package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with chaining.
 * Does not support load balancing or resizing.
 * 
 * @author (put your name here), Sedgewick and Wayne, Acuna
 */
import java.util.LinkedList;
import java.util.Queue;

public class CompletedTwoProbeChainHT<Key, Value> implements TwoProbeChainHT<Key, Value> {

    private int M;
    private int N;
    private LinkedList<Node>[] entries;

    private static class Node {
        private Object key;
        private Object val;

        public Node(Object key, Object val) {
            this.key = key;
            this.val = val;
        }
    }

    public CompletedTwoProbeChainHT(int M) {
        this.M = M;
        this.entries = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            this.entries[i] = new LinkedList<>();
        }
    }

    public CompletedTwoProbeChainHT() {
        this(11);
    }

    @Override
    public void put(Key key, Value val) {
        int h = hash(key);
        int h2 = hash2(key);

        int i = Math.min(h, h2);
        int j = Math.max(h, h2);
        for (Node n : entries[i]) {
            if (n.key.equals(key)) {
                n.val = val;
                return;
            }
        }
        if (entries[i].size() > entries[j].size()) {
            entries[j].add(new Node(key, val));
        } else {
            entries[i].add(new Node(key, val));
        }
        N++;
    }

    @Override
    public Value get(Key key) {
        int h = hash(key);
        int h2 = hash2(key);

        int i = Math.min(h, h2);
        int j = Math.max(h, h2);
        for (Node n : entries[i]) {
            if (n.key.equals(key)) {
                return (Value) n.val;
            }
        }
        for (Node n : entries[j]) {
            if (n.key.equals(key)) {
                return (Value) n.val;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        int h = hash(key);
        int h2 = hash2(key);

        int i = Math.min(h, h2);
        for (Node n : entries[i]) {
            if (n.key.equals(key)) {
                entries[i].remove(n);
                N--;
                return;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (Node n : entries[i]) {
                q.add((Key) n.key);
            }
        }
        return q;
    }

    @Override
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public int hash2(Key key) {
        return (((key.hashCode() & 0x7fffffff) % M) * 31) % M;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // THESE METHODS ARE ONLY FOR GRADING AND COME FROM THE TWOPROBECHAINHT
    //////////////////////////////////////////////////////////////////////////////////////////////// INTERFACE.

    @Override
    public int getM() {
        return M;
    }

    @Override
    public int getChainSize(int i) {
        return entries[i].size();
    }
}