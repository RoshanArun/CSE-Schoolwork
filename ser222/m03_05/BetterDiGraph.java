package ser222.m03_05;

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

    // vertece - big circles, edges - connections, support self loops/parallel edges
    // graphs are generic data structures (multiple representations),
    // define an ADT to enforce separation of function/implementation
    // graph representation - adjacency matrices, adjacency lists, and edge lists
    // Matrix - make a true/false grid, space - worst case needs O(|v|^2) - time
    // complexity
    // no self loop, supports parallel edges, uses boolean array, removing edge and
    // querying is o(1)
    // Lists - where each index corresponds to a list of vertices that are connected
    // to that index, querying-O(V)
    // uses a linkedList array, space - O(V+2E) worst case: O(V^2). Add edge, both
    // use O(1), add edge is O(E)
    // (check adjacent matrix: 1, list: degree(V)), (iterate adjacent: matrix: V,
    // list: degree (V))
    // Edge Lists - list of all connected edges, example would be [1.2] edge list is
    // array, to find something must
    // iterate through, could have no sense of order - edge could be at the end,
    // taking linear time
    // DFS - Starts as some node, mark as visited, recusively visit each neighbor if
    // not marked (Uses stack)
    // BFS - Starts as some node, mark as visited, add each of its negihbors to a
    // queue if not marked (uses queue)
    // Continue using the queue to look at nodes in FIFO(first in first out order),
    // DFS uses LIFO (last in first out)
    // DFS is faster and requires less memroy, best suited for decison trees, better
    // when target if far from source
    // BFS is better when target is closer to source, time complexity BFS/DFS:
    // O(V+E), BFS needs more space
    // DFS could be stuck in infite loop Cycle - Path where the first and last nodes
    // are the same
    // Connected Component - subset of a garph where every pair of verticed are
    // connected by some path

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