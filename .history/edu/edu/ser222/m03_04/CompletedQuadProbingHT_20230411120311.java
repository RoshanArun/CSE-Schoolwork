package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with quadratic probing.
 * 
 * @author (put your name here), Acuna
 */
public class CompletedQuadProbingHT<Key, Value> extends CompletedLinearProbingHT<Key, Value> {

    public CompletedQuadProbingHT() {
        super();
    }

    public CompletedQuadProbingHT(int capacity) {
        super(capacity);
    }

    /**
     * Creates a hash for the given key in the range [0, capacity - 1].
     * 
     * @param key
     * @param index
     * @return the index of the key in the hash table
     */
    @Override
    protected int hash(Key key, int index) {
        return (key.hashCode() & 0x7fffffff + index * index) % capacity;
    }

}