package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BetterDiGraph implements EditableDiGraph {

    private HashMap<Integer, LinkedList<Integer>> adj;
    private int numberOfVertices;
    private int numberOfEdges;

    public BetterDiGraph() {
        this.adj = new HashMap<Integer, LinkedList<Integer>>();
        this.numberOfVertices = 0;
        this.numberOfEdges = 0;
    }

    @Override
    public void addEdge(int v, int w) {
        if (!adj.containsKey(v)) {
            addVertex(v);
        }
        if (!adj.containsKey(w)) {
            addVertex(w);
        }
        adj.get(v).add(w);
        numberOfEdges++;
    }

    @Override
    public void addVertex(int v) {
        if (!adj.containsKey(v)) {
            adj.put(v, new LinkedList<Integer>());
            numberOfVertices++;
        }
    }

    @Override
    public Iterable<Integer> getAdj(int v) {
        if (!adj.containsKey(v)) {
            throw new NoSuchElementException();
        }
        return adj.get(v);
    }

    @Override
    public int getEdgeCount() {
        return numberOfEdges;
    }

    @Override
    public int getIndegree(int v) throws NoSuchElementException {
        if (!adj.containsKey(v)) {
            throw new NoSuchElementException();
        }
        int indegree = 0;
        for (Integer w : adj.keySet()) {
            if (adj.get(w).contains(v)) {
                indegree++;
            }
        }
        return indegree;
    }

    @Override
    public int getVertexCount() {
        return numberOfVertices;
    }

    @Override
    public void removeEdge(int v, int w) {
        if (adj.containsKey(v) && adj.containsKey(w)) {
            adj.get(v).remove(w);
            numberOfEdges--;
        }
    }

    @Override
    public void removeVertex(int v) {
        if (adj.containsKey(v)) {
            LinkedList<Integer> vList = new LinkedList<Integer>();
            vList.add(v);
            while (!vList.isEmpty()) {
                int curr = vList.poll();
                for (Integer w : adj.get(curr)) {
                    if (adj.containsKey(w)) {
                        vList.add(w);
                        removeEdge(curr, w);
                    }
                }
                adj.remove(curr);
                numberOfVertices--;
            }
        }
    }

    @Override
    public Iterable<Integer> vertices() {
        return adj.keySet();
    }

    @Override
    public boolean isEmpty() {
        return adj.isEmpty();
    }

    @Override
    public boolean containsVertex(int v) {
        return adj.containsKey(v);
    }

    // Algorithm for finding the topological sort of a graph

    public static List<Integer> topologicalSort(BetterDiGraph graph) {
        LinkedList<Integer> sortedList = new LinkedList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> indegrees = new HashMap<Integer, Integer>();

        // Populate the indegrees hashmap
        for (Integer v : graph.vertices()) {
            indegrees.put(v, graph.getIndegree(v));
        }

        // Populate the queue with vertices that have an indegree of 0
        for (Integer v : graph.vertices()) {
            if (indegrees.get(v) == 0) {
                queue.add(v);
            }
        }

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            sortedList.add(v);

            // Decrement indegrees of the adjacent vertices
            for (Integer w : graph.getAdj(v)) {
                indegrees.put(w, indegrees.get(w) - 1);
                if (indegrees.get(w) == 0) {
                    queue.add(w);
                }
            }
        }

        return sortedList;
    }
}