package test;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;

public class BaseMain {

    /**
     * Entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO: implement this

        // Create the graph
        BetterDiGraph graph = new BetterDiGraph();
        HashMap<Integer, Character> indexMapping = new HashMap<Integer, Character>();

        // Load kanji data
        try {
            BufferedReader indexReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), StandardCharsets.UTF_8));
            String line;
            while ((line = indexReader.readLine()) != null) {
                line = line.trim();
                // ignore comments
                if (!line.startsWith("#")) {
                    String[] components = line.split("\t");
                    int index = Integer.parseInt(components[0]);
                    char kanji = components[1].charAt(0);
                    indexMapping.put(index, kanji);
                    graph.addVertex(index);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading kanji data!");
            e.printStackTrace();
            System.exit(1);
        }

        // Load component data
        try {
            BufferedReader componentReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File("data-components.txt")), StandardCharsets.UTF_8));
            String line;
            while ((line = componentReader.readLine()) != null) {
                line = line.trim();
                // ignore comments
                if (!line.startsWith("#")) {
                    String[] components = line.split("\t");
                    int parentIndex = Integer.parseInt(components[0]);
                    int childIndex = Integer.parseInt(components[1]);
                    graph.addEdge(parentIndex, childIndex);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading component data!");
            e.printStackTrace();
            System.exit(1);
        }

        // Perform the topological sort
        IntuitiveTopological topological = new IntuitiveTopological(graph);
        try {
            LinkedList<Integer> sorted = (LinkedList<Integer>) topological.order();
            for (Integer v : sorted) {
                System.out.print(indexMapping.get(v) + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Graph contains a cycle!");
        }
    }
}