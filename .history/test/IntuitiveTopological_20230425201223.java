package test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implements an intuitive topological sort algorithm for a graph.
 * 
 * @author Acuna
 */
public class IntuitiveTopologicalSort implements TopologicalSort {

    private BetterDiGraph graph;
    private LinkedList<Integer> order;

    /**
     * Constructor for IntuitiveTopologicalSort.
     *
     * @param g graph
     */
    public IntuitiveTopologicalSort(BetterDiGraph g) {
        graph = g;
        order = new LinkedList<>();
    }

    /**
     * Uses an intuitive topological sort algorithm to find an ordering of the
     * graph.
     *
     * @return iterable object containing order
     */
    public Iterable<Integer> order() {
        while (!graph.isEmpty()) {
            for (int v : graph.vertices()) {
                try {
                    if (graph.getIndegree(v) == 0) {
                        order.add(v);
                        graph.removeVertex(v);
                        break;
                    }
                } catch (NoSuchElementException e) {
                    // Do nothing
                }
            }
        }
        return order;
    }

    /**
     * Returns true if the graph is a DAG, false otherwise.
     * 
     * @return boolean
     */
    public boolean isDAG() {
        return graph.getEdgeCount() == 0;
    }
}