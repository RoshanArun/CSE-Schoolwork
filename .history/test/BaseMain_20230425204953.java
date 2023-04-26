package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.nio.charset.StandardCharsets;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author Acuna
 * @version 1.0
 */
public class BaseMain {

    /**
     * Entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Load files
            HashMap<Integer, String> kanji = new HashMap<>();

            // BufferedReader kanjiReader = new BufferedReader(
            // new InputStreamReader(new FileInputStream(new File("data-kanji.txt")),
            // StandardCharsets.UTF_8));

            FileReader fr = new FileReader("data-kanji.txt", StandardCharsets.UTF_8);
            BufferedReader kanjiReader = new BufferedReader(fr);

            String line;
            while ((line = kanjiReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                System.out.print(line);
                String[] tokens = line.split("\t");
                int heisigNum = Integer.parseInt(tokens[0]);
                String kanjiChar = tokens[1];
                kanji.put(heisigNum, kanjiChar);
            }
            kanjiReader.close();

            HashMap<Integer, LinkedList<Integer>> components = new HashMap<>();
            BufferedReader componentsReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File("data-components.txt")),
                            StandardCharsets.UTF_8));
            while ((line = componentsReader.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                String[] tokens = line.split("\t");
                int src = Integer.parseInt(tokens[0]);
                int dst = Integer.parseInt(tokens[1]);

                LinkedList<Integer> srcList = components.get(src);
                if (srcList == null) {
                    srcList = new LinkedList<>();
                    components.put(src, srcList);
                }
                srcList.add(dst);
            }
            componentsReader.close();

            // Create graph
            BetterDiGraph graph = new BetterDiGraph();
            for (int src : components.keySet()) {
                graph.addVertex(src);
                for (int dst : components.get(src)) {
                    graph.addVertex(dst);
                    graph.addEdge(src, dst);
                }
            }

            // Generate topological sort
            IntuitiveTopological topo = new IntuitiveTopological(graph);
            Iterable<Integer> order = topo.order();
            System.out.println("Kanji Component Order:");
            for (int v : order) {
                System.out.print(kanji.get(v));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}