package test;

import java.util.LinkedList;
import java.util.List;

public class IntuitiveTopological implements TopologicalSort {
    private BetterDiGraph graph;
    private List<Integer> sortedList;
    private boolean isDAG;

    public IntuitiveTopological(BetterDiGraph graph) {
        this.graph = graph;
        this.sortedList = new LinkedList<Integer>();
        this.isDAG = true;

        // Check for cycles
        for (Integer v : graph.vertices()) {
            if (graph.getIndegree(v) != ((List<Integer>) graph.getAdj(v)).size()) {
                this.isDAG = false;
            }
        }

        // Find the topological order
        while (!graph.isEmpty()) {
            int zeroInDegreeVertex = -1;
            for (Integer v : graph.vertices()) {
                if (graph.getIndegree(v) == 0) {
                    zeroInDegreeVertex = v;
                    break;
                }
            }
            sortedList.add(zeroInDegreeVertex);
            graph.removeVertex(zeroInDegreeVertex);
        }
    }

    @Override
    public Iterable<Integer> order() {
        return sortedList;
    }

    @Override
    public boolean isDAG() {
        return isDAG;
    }
}
