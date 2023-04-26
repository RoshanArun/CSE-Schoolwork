package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

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
        BufferedReader kanjiReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
        BufferedReader componentReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF8"));

        // Create graph
        BetterDiGraph graph = new BetterDiGraph();
        HashMap<Integer, String> kanjiMap = new HashMap<Integer, String>();

        // Load the kanji data
        try {
            String line;
            while ((line = kanjiReader.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    String[] kanji = line.split("\t");
                    int id = Integer.parseInt(kanji[0].substring(1));
                    String character = kanji[1];
                    graph.addVertex(id);
                    kanjiMap.put(id, character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the component data
        try {
            String line;
            while ((line = componentReader.readLine()) != null) {
                String[] components = line.split("\t");
                int id1 = Integer.parseInt(components[0].substring(1));
                int id2 = Integer.parseInt(components[1].substring(1));
                graph.addEdge(id1, id2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate topological sort
        IntuitiveTopological topo = new IntuitiveTopological(graph);
        List<Integer> order = topo.order();

        // Print topological order
        System.out.println("Topological Order:");
        for (Integer v : order) {
            System.out.println(kanjiMap.get(v));
        }
    }
}