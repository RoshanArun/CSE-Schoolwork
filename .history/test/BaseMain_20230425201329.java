package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

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
        try {
            BufferedReader componentsReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF8"));
            BufferedReader kanjiReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
            HashMap<Integer, String> kanjiMap = new HashMap<>();
            String line;
            while ((line = kanjiReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                String[] components = line.split("\t");
                kanjiMap.put(Integer.parseInt(components[0]), components[1]);
            }
            while ((line = componentsReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                String[] components = line.split("\t");
                graph.addEdge(Integer.parseInt(components[0]), Integer.parseInt(components[1]));
            }
            IntuitiveTopological sort = new IntuitiveTopological(graph);
            if (sort.isDAG()) {
                System.out.println("Kanji Component Order:");
                for (int v : sort.order()) {
                    String kanji = kanjiMap.get(v);
                    if (kanji != null)
                        System.out.println(kanji);
                    else
                        System.out.println(v);
                }
            } else {
                System.out.println("Graph contains a cycle! Cannot generate a topological sort.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}