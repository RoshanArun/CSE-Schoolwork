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

    // takes a key a produces a integer has to encode identity
    // hash = 31 * hash + who.hashCode() (the requirements below is a perfect hash)
    // must be consistent(deterministic), effcient to compute, uniformly distrubuted
    // chaining - hash(k) = k mod 5, linear probing- hash(k, i) = (k mod 11 + i) mod 11
    // Hash function coverts data of arbitrary length to a fixed length. LP: requires resize
    // collision handling - chaining, linear probing, quadprobing (hash(x) + 1*1) % S)
    // Chaining - need to get the first element from the list to get value required. 
    // Need to access the pointer to the head of list and value: 2 operations
    // open-addressing - linear-probing, require only 1 operation, chaining: large data sets
    // when HashTable gets full, collisions happen more often (high load factor)
    // probing requires you to check more Hashtable locations before finding the value needed.
    // At load factor of 0.8, chaining becomes more efficient due to multiple collisions: 
    //you would have to probe a lot of empty cells in order to find the actual value you want 
    //with probing, while with chaining you have a list of values that have the same hash key.
    //chaining S: N/2M, I:N/M, No. Linear Probing: S: <1.5, I: <2.5, no. 
    
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
    public Value get(Key key) { //put(Value val)
        //if key = null reuturn null
        if (key == null) {return null;} int i = 0; //put (return;)
        //put if (val == null) {delete(key); return;} if val is null delete associated key
        while (i < M) {
            int h = hash(key, i); //gets hash of key
            if (entries[h] == null) {
        //put entries[h] = new Entry<Key, Value>(key, val); size++; adds key/value
                break;} // If the entry at the specified index is null, break out of the loop
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                // If the key at this index equals the key we are looking for, return its value
        //put ((Entry<Key, Value>) entries[h]).val = val; break; // If key at index equals key update value
                return ((Entry<Key, Value>) entries[h]).val;}
            i++;} //increment loop counter
        return null; //if key not found return null
    }

    @Override
    public void delete(Key key) {
        if (key == null) {return;} 
        int i = 0;
        while (i < M) {
            int h = hash(key, i);
            // If the entry at the specified index is null, break out of the loop
            if (entries[h] == null) {break;}
            // If the key at this index equals the key we are looking for, delete it
            if (((Entry<Key, Value>) entries[h]).key.equals(key)) {
                entries[h] = null; size--; break;}
            i++;
        }

        i++;
        // Iterate through the entries array again
        while (i < M) {
            int h = hash(key, i);
            if (entries[h] == null) {break;}
            // Get the entry at this index
            Entry<Key, Value> entry = (Entry<Key, Value>) entries[h];
            // Delete the entry at this index
            entries[h] = null; size--;
            // Put the deleted entry back into the entries array
            put(entry.key, entry.val);i++;
        }
    }

    //produce hashes in the range [0, M-1]
    //uniformly distributed over that interval
    //If hash value large, use smaller domain k%M.
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