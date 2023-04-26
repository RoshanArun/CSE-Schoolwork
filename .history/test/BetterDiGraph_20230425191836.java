public class BetterDiGraph implements EditableDiGraph {

    // Data field to store the graph
    private int[][] graph;
    private int numVertices;
    private int numEdges;

    // Default constructor
    public BetterDiGraph() {
        this.graph = new int[0][0];
        this.numVertices = 0;
        this.numEdges = 0;
    }

    @Override
    public void addEdge(int v, int w) {
        // Checks if vertices exist, adds them if they don't
        if (!this.containsVertex(v)) {
            addVertex(v);
        }
        if (!this.containsVertex(w)) {
            addVertex(w);
        }

        // Makes new graph with larger size to fit new edges
        int[][] newGraph = new int[this.numVertices + 1][this.numVertices + 1];

        // Copies old graph into new graph
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                newGraph[i][j] = this.graph[i][j];
            }
        }

        // Inserts new edge
        newGraph[v - 1][w - 1] = 1;
        this.graph = newGraph;

        // Increases the edge and vertex count
        this.numEdges++;
        this.numVertices++;
    }

    @Override
    public void addVertex(int v) {
        // Checks if vertex already exists
        if (this.containsVertex(v)) {
            return;
        }

        // Makes new graph with larger size to fit new vertex
        int[][] newGraph = new int[this.numVertices + 1][this.numVertices + 1];

        // Copies old graph into new graph
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                newGraph[i][j] = this.graph[i][j];
            }
        }

        this.graph = newGraph;
        this.numVertices++;
    }

    @Override
    public Iterable<Integer> getAdj(int v) {
        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (this.graph[v - 1][i] == 1) {
                adj.add(i + 1);
            }
        }
        return adj;
    }

    @Override
    public int getEdgeCount() {
        return this.numEdges;
    }

    @Override
    public int getIndegree(int v) throws NoSuchElementException {
        if (!this.containsVertex(v)) {
            throw new NoSuchElementException("Vertex does not exist.");
        }

        int count = 0;
        for (int i = 0; i < this.numVertices; i++) {
            if (this.graph[i][v - 1] == 1) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getVertexCount() {
        return this.numVertices;
    }

    @Override
    public void removeEdge(int v, int w) {
        // Checks if vertices exist
        if (!this.containsVertex(v) || !this.containsVertex(w)) {
            return;
        }

        // Makes new graph with smaller size to fit new edges
        int[][] newGraph = new int[this.numVertices - 1][this.numVertices - 1];

        // Copies old graph into new graph
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (i != v - 1 && j != w - 1) {
                    newGraph[i][j] = this.graph[i][j];
                }
            }
        }

        this.graph = newGraph;

        // Decreases the edge and vertex count
        this.numEdges--;
        this.numVertices--;
    }

    @Override
    public void removeVertex(int v) {
        // Checks if vertex exists
        if (!this.containsVertex(v)) {
            return;
        }

        // Makes new graph with smaller size to fit new edges
        int[][] newGraph = new int[this.numVertices - 1][this.numVertices - 1];

        // Copies old graph into new graph
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (i != v - 1 && j != v - 1) {
                    newGraph[i][j] = this.graph[i][j];
                }
            }
        }

        this.graph = newGraph;

        // Decreases the vertex count
        this.numVertices--;
    }

    @Override
    public Iterable<Integer> vertices() {
        ArrayList<Integer> vertices = new ArrayList<>();
        for (int i = 1; i <= this.numVertices; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public boolean isEmpty() {
        return this.numVertices == 0;
    }

    @Override
    public boolean containsVertex(int v) {
        for (int vertex : this.vertices()) {
            if (vertex == v) {
                return true;
            }
        }
        return false;
    }

    // Helper method to find the topological sort of a graph
    public int[] topologicalSort() {
        int[] order = new int[this.numVertices];
        int count = 0;
        while (this.getVertexCount() > 0) {
            for (int v : this.vertices()) {
                if (this.getIndegree(v) == 0) {
                    order[count] = v;
                    this.removeVertex(v);
                    count++;
                    break;
                }
            }
        }
        return order;
    }
}