package Default;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implements an editable graph with sparse vertex support.
 * 
 * @author Acuna
 */
public class BetterDiGraph implements EditableDiGraph {

    private HashMap<Integer, LinkedList<Integer>> graph;
    private int numVertices;
    private int numEdges;

    /**
     * Default constructor for BetterDiGraph.
     */
    public BetterDiGraph() {
        graph = new HashMap<>();
        numVertices = 0;
        numEdges = 0;
    }

    /**
     * Adds an edge between two vertices, v and w. If vertices do not exist,
     * adds them first.
     *
     * @param v source vertex
     * @param w destination vertex
     */
    public void addEdge(int v, int w) {
        if (v == w)
            return;
        LinkedList<Integer> vList = graph.get(v);
        LinkedList<Integer> wList = graph.get(w);
        if (vList == null) {
            addVertex(v);
            vList = graph.get(v);
        }
        if (wList == null) {
            addVertex(w);
            wList = graph.get(w);
        }
        vList.add(w);
        numEdges++;
    }

    /**
     * Adds a vertex to the graph. Does not allow duplicate vertices.
     *
     * @param v vertex number
     */
    public void addVertex(int v) {
        if (graph.containsKey(v))
            return;
        graph.put(v, new LinkedList<>());
        numVertices++;
    }

    /**
     * Returns the direct successors of a vertex v.
     *
     * @param v vertex
     * @return successors of v
     */
    public Iterable<Integer> getAdj(int v) {
        return graph.get(v);
    }

    /**
     * Number of edges.
     *
     * @return edge count
     */
    public int getEdgeCount() {
        return numEdges;
    }

    /**
     * Returns the in-degree of a vertex.
     * 
     * @param v vertex
     * @return in-degree.
     * @throws NoSuchElementException exception thrown if vertex does not exist.
     */
    public int getIndegree(int v) throws NoSuchElementException {
        if (!graph.containsKey(v))
            throw new NoSuchElementException("Vertex does not exist in graph.");
        int inDegree = 0;
        for (int w : graph.keySet()) {
            LinkedList<Integer> wList = graph.get(w);
            for (int x : wList) {
                if (x == v)
                    inDegree++;
            }
        }
        return inDegree;
    }

    /**
     * Returns number of vertices.
     * 
     * @return vertex count
     */
    public int getVertexCount() {
        return numVertices;
    }

    /**
     * Removes edge from graph. If vertices do not exist, does not remove edge.
     *
     * @param v source vertex
     * @param w destination vertex
     */
    public void removeEdge(int v, int w) {
        LinkedList<Integer> vList = graph.get(v);
        if (vList == null)
            return;
        if (vList.contains(w)) {
            vList.remove(vList.indexOf(w));
            numEdges--;
        }
    }

    /**
     * Removes vertex from graph. If vertex does not exist, does not try to
     * remove it.
     *
     * @param v vertex
     */
    public void removeVertex(int v) {
        if (!graph.containsKey(v))
            return;
        graph.remove(v);
        for (LinkedList<Integer> x : graph.values()) {
            if (x.contains(v)) {
                x.remove(x.indexOf(v));
                numEdges--;
            }
        }
        numVertices--;
    }

    /**
     * Returns iterable object containing all vertices in graph.
     *
     * @return iterable object of vertices
     */
    public Iterable<Integer> vertices() {
        return graph.keySet();
    }

    /**
     * Returns false if the graph contains at least one vertex.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return numVertices == 0;
    }

    /**
     * Returns true if the graph contains a specific vertex.
     *
     * @param v vertex
     * @return boolean
     */
    public boolean containsVertex(int v) {
        return graph.containsKey(v);
    }
}