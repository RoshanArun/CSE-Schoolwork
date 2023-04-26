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

        BetterDiGraph graph = new BetterDiGraph();
        HashMap<Integer, String> kanjiIndex = new HashMap<Integer, String>();

        String line;
        while ((line = indexReader.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] entry = line.split("\t");
            int id = Integer.parseInt(entry[0]);
            String kanji = entry[1];
            kanjiIndex.put(id, kanji);
            graph.addVertex(id);
        }

        BufferedReader graphReader = new BufferedReader(new FileReader("data-components.txt"));
        while ((line = graphReader.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] entry = line.split("\t");
            if (entry.length < 2) {
                continue;
            }
            int v = Integer.parseInt(entry[0]);
            int w = Integer.parseInt(entry[1]);
            graph.addEdge(v, w);
        }

        IntuitiveTopological topological = new IntuitiveTopological(graph);
        for (Integer v : topological.order()) {
            System.out.println(kanjiIndex.get(v));
        }
    }
}