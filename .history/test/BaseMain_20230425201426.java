package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author Acuna
 * @version 1.0
 */
public class BaseMain {

    private static HashMap<Integer, Character> indexMap;

    /**
     * Entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        indexMap = new HashMap<>();
        BetterDiGraph graph = new BetterDiGraph();

        // Load the UTF8 formated character data.
        try {
            // Load the index data first
            BufferedReader indexReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
            String line;
            while ((line = indexReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                StringTokenizer st = new StringTokenizer(line);
                indexMap.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
            }
            indexReader.close();

            // Load the graph data
            BufferedReader graphReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-components.txt")), "UTF8"));
            while ((line = graphReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                StringTokenizer st = new StringTokenizer(line);
                graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            graphReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        IntuitiveTopological topSort = new IntuitiveTopological(graph);
        Iterable<Integer> order = topSort.order();
        for (int x : order) {
            System.out.println(indexMap.get(x));
        }
    }
}