package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BaseMain {

    /**
     * Entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BetterDiGraph graph = new BetterDiGraph();
        HashMap<Integer, Character> kanjiMap = new HashMap<Integer, Character>();

        // Freebie: this is one way to load the UTF8 formated character data.
        BufferedReader indexReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
        while (indexReader.ready()) {
            String line = indexReader.readLine();
            if (!line.startsWith("#")) {
                String[] parts = line.split("\t");
                int heisigNum = Integer.parseInt(parts[0]);
                char kanji = parts[1].charAt(0);
                kanjiMap.put(heisigNum, kanji);
                graph.addVertex(heisigNum);
            }
        }

        // Load the component data from the second file
        BufferedReader indexReader2 = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF8"));

        while (indexReader2.ready()) {
            String line = indexReader2.readLine();
            String[] parts = line.split("\t");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.addEdge(from, to);
        }

        // Sort the graph
        IntuitiveTopological topological = new IntuitiveTopological(graph);
        List<Integer> sorted = (List<Integer>) topological.order();
        if (topological.isDAG()) {
            System.out.println("Kanji Component Order:");
            for (Integer v : sorted) {
                System.out.print(kanjiMap.get(v) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Graph contains a cycle, no topological order exists.");
        }
    }
}