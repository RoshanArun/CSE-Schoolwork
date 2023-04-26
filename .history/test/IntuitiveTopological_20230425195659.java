package test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class IntuitiveTopological implements TopologicalSort {

    private BetterDiGraph graph;

    public IntuitiveTopological(BetterDiGraph graph) {
        if (!graph.isEmpty()) {
            this.graph = graph;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterable<Integer> order() {
        LinkedList<Integer> sortedList = new LinkedList<Integer>();
        while (!graph.isEmpty()) {
            // Find a vertex with indegree of 0
            Integer v = null;
            for (Integer w : graph.vertices()) {
                if (graph.getIndegree(w) == 0) {
                    v = w;
                    break;
                }
            }
            if (v == null) {
                throw new IllegalArgumentException("Graph contains a cycle");
            }
            // Add vertex to the sorted list
            sortedList.add(v);
            // Remove vertex from the graph
            graph.removeVertex(v);
        }
        return sortedList;
    }

    @Override
    public boolean isDAG() {
        return IntuitiveTopological.isDAG(graph);
    }

    public static boolean isDAG(BetterDiGraph graph) {
        for (Integer v : graph.vertices()) {
            if (graph.getIndegree(v) > 0) {
                return false;
            }
        }
        return true;
    }

}
