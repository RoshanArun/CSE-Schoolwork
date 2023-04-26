import java.util.LinkedList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class BetterDiGraph implements EditableDiGraph {

    // Data Structure to store the graph
    private HashMap<Integer, LinkedList<Integer>> graph;

    // Default constructor
    public BetterDiGraph() {
        graph = new HashMap<>();
    }

    // Method to add a node to the graph
    @Override
    public void addNode(int node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new LinkedList<>());
        }
    }

    // Method to remove a node from the graph
    @Override
    public void removeNode(int node) {
        if (graph.containsKey(node)) {
            // Remove all incoming edges
            for (int inNode : graph.keySet()) {
                if (graph.get(inNode).contains(node)) {
                    graph.get(inNode).remove(node);
                }
            }
            // Remove node
            graph.remove(node);
        } else {
            throw new NoSuchElementException("Node not found");
        }
    }

    // Method to add an edge to the graph
    @Override
    public void addEdge(int from, int to) {
        if (graph.containsKey(from) && graph.containsKey(to)) {
            if (!graph.get(from).contains(to)) {
                graph.get(from).add(to);
            }
        } else {
            throw new NoSuchElementException("Nodes not found");
        }
    }

    // Method to remove an edge from the graph
    @Override
    public void removeEdge(int from, int to) {
        if (graph.containsKey(from) && graph.containsKey(to)) {
            if (graph.get(from).contains(to)) {
                graph.get(from).remove(to);
            }
        } else {
            throw new NoSuchElementException("Nodes not found");
        }
    }

    // Method to get the adjacency list of a node
    @Override
    public LinkedList<Integer> getAdjacent(int node) {
        if (graph.containsKey(node)) {
            return graph.get(node);
        } else {
            throw new NoSuchElementException("Node not found");
        }
    }

    // Method to get the incoming edges of a node
    @Override
    public LinkedList<Integer> getIncoming(int node) {
        LinkedList<Integer> incomingList = new LinkedList<>();
        for (int inNode : graph.keySet()) {
            if (graph.get(inNode).contains(node)) {
                incomingList.add(inNode);
            }
        }
        return incomingList;
    }

    // Method to get the topological sort of the graph
    @Override
    public LinkedList<Integer> topologicalSort() {
        LinkedList<Integer> sortedList = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        // Create a map to store indegree of each node
        HashMap<Integer, Integer> indegreeMap = new HashMap<>();
        // Initialize indegree map
        for (int node : graph.keySet()) {
            indegreeMap.put(node, getIncoming(node).size());
            if (indegreeMap.get(node) == 0) {
                queue.add(node);
            }
        }
        // Iterate until all nodes are processed
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            sortedList.add(node);
            // Process neighbours
            LinkedList<Integer> neighbours = getAdjacent(node);
            for (int neighbour : neighbours) {
                indegreeMap.put(neighbour, indegreeMap.get(neighbour) - 1);
                if (indegreeMap.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        // Check if all nodes are processed
        if (sortedList.size() != graph.keySet().size()) {
            throw new IllegalArgumentException("Graph has at least one cycle");
        }
        return sortedList;
    }
}