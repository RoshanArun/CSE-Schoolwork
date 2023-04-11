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

    public CompletedQuadProbingHT(int m) {
        super(m);
    }

    @Override
    public int hash(Key key, int i) {
        return (int) (super.hash(key, i) + Math.pow(i, 2)) % super.getM();
    }
}