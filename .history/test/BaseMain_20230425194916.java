package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
    public static void main(String[] args) {
        try {
            // Load the UTF8 formated character data.
            BufferedReader indexReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF-8"));

            // Create the graph and the hashmap
            BetterDiGraph graph = new BetterDiGraph();
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            String line;
            while ((line = indexReader.readLine()) != null) {
                String[] data = line.split("\t");
                int key = Integer.parseInt(data[0]);
                String value = data[1];
                graph.addVertex(key);
                map.put(key, value);
            }
            indexReader.close();

            // Load the component data
            BufferedReader componentsReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF-8"));
            while ((line = componentsReader.readLine()) != null) {
                String[] data = line.split("\t");
                int v = Integer.parseInt(data[0]);
                int w = Integer.parseInt(data[1]);
                graph.addEdge(v, w);
            }
            componentsReader.close();

            // Print the topological sort result
            IntuitiveTopological topological = new IntuitiveTopological(graph);
            System.out.println("Kanji component dependency order:");
            Iterable<Integer> sortedList = topological.order();
            for (Integer v : sortedList) {
                System.out.println(map.get(v));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}