package test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implements an intuitive topological sort algorithm for a graph.
 * 
 * @author Acuna
 */
public class IntuitiveTopological implements TopologicalSort {

    private BetterDiGraph graph;
    private LinkedList<Integer> order;

    /**
     * Constructor for IntuitiveTopologicalSort.
     *
     * @param g graph
     */
    public IntuitiveTopological(BetterDiGraph g) {
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

//V is a Direct Predecessor of W if: there is a v to w edge.
//V is a Direct Successor of W if: there is a w to v edge.
//V is a Predecessor of W if: v is a direct predecessor of w or predecessor of a direct predecessor of w.
//V is a Successor of W if: v is a direct successor of w or a successor of a direct successor of w.
//Maintain a list of all nodes in the graph., Pick out the node with the minimum distTo.*
//Dijkstra's algorithm Relax that node. Remove that node from the list and go to pick out new node.
//memozation - storing computation results in cache, and retrieving that same information from the cache when needed
//pruning -  data compression technique in machine learning and search algorithms that reduces the size of decision 
//trees by removing sections of the tree that are non-critical
//Parallelization is the act of designing a computer program or system to process data in parallel
public Digraph reverse() //adjListgraph, with a new function
{ Digraph R = new Digraph(V); for (int v = 0; v < V; v++) for (int w : adj(v))
    R.addEdge(w, v); return R;}
    