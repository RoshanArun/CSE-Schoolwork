package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
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
        // Freebie: this is one way to load the UTF8 formated character data.
        BufferedReader indexReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));

        // Maps the kanji ID to the kanji character
        HashMap<Integer, String> kanjiMap = new HashMap<Integer, String>();

        String line;
        try {
            while ((line = indexReader.readLine()) != null) {
                if (line.startsWith("#")) {
                    String[] parts = line.split("\t");
                    int id = Integer.parseInt(parts[0].substring(1));
                    kanjiMap.put(id, parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the graph
        BetterDiGraph graph = new BetterDiGraph();
        for (Integer id : kanjiMap.keySet()) {
            graph.addVertex(id);
        }

        // Load the components data
        BufferedReader componentsReader = new BufferedReader(new FileReader("data-components.txt"));
        try {
            while ((line = componentsReader.readLine()) != null) {
                String[] parts = line.split("\t");
                int v = Integer.parseInt(parts[0]), w = Integer.parseInt(parts[1]);
                graph.addEdge(v, w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate the topological order
        IntuitiveTopological topological = new IntuitiveTopological(graph);
        System.out.println("Topological Order:");
        for (Integer id : topological.order()) {
            System.out.println(kanjiMap.get(id));
        }
    }

}