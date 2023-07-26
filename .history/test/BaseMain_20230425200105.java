package test;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class BaseMain {

    /**
     * Entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BetterDiGraph graph = new BetterDiGraph();
        HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>();

        // Load data-kanji.txt and use it to populate the hashtable and graph
        try {
            BufferedReader indexReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
            String line = indexReader.readLine();
            while (line != null) {
                // Ignore commented lines
                if (!line.startsWith("#")) {
                    String[] parts = line.split("\t");
                    Integer id = Integer.parseInt(parts[0]);
                    char c = (char) Integer.parseInt(parts[1], 16);
                    idToChar.put(id, c);
                    graph.addVertex(id);
                }
                line = indexReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error loading kanji data: " + e.getMessage());
        }

        // Load data-components.txt and use it to add edges to the graph
        try {
            BufferedReader indexReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF8"));
            String line = indexReader.readLine();
            while (line != null) {
                // Ignore commented lines
                if (!line.startsWith("#")) {
                    String[] parts = line.split("\t");
                    Integer w = Integer.parseInt(parts[0]);
                    Integer v = Integer.parseInt(parts[1]);
                    graph.addEdge(w, v);
                }
                line = indexReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error loading components data: " + e.getMessage());
        }

        // Create an intuitive topological object and use it to sort the graph
        IntuitiveTopological t = new IntuitiveTopological(graph);
        Iterable<Integer> order = t.order();

        // Display the characters in the ordering
        System.out.println("Kanji Component Order:");
        for (Integer i : order) {
            System.out.print(idToChar.get(i));
        }
        System.out.println();
    }
}