package Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day9 {

    public static List<String> readLinesFromFile(String filePath) {
        List<String> lines = null;
        Path path = Paths.get(filePath);
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/Siu/Desktop/aoc2023/d9.txt";
        List<Integer> series = new ArrayList<>();
        List<String> lines = readLinesFromFile(filePath);
        ArrayList<List<Integer>> output = new ArrayList<>();
        int sum = 0;

        for (String str : lines) {
            int g = 0;
            int h = 0;
            int u = 0;
            String[] s = str.split(" ");
            for (String st : s) {
                series.add(Integer.parseInt(st));
            }
            output = analyzeNumberSeries(series);
            for (int k = output.size() - 1; k >= 0; k--) {
                List<Integer> list = output.get(k);

                if ((k - 1) >= 0) {
                    List<Integer> blist = output.get(k - 1);
                    g = list.get(0);
                    u = blist.get(0);
                    h = u-g;

                    System.out.println("G: " + h);
                    blist.add(0, h);

                }

                for (int i : list) {
                    System.out.print(i + " ");
                }

            }
            System.out.println();
            System.out.println("____________________");
            int e = series.get(0) - h;
            System.out.println("HJ: " + series.get(0));
            series.add(0, series.get(0) + h);
            System.out.println("S: " + e);
            sum=sum+e;
            series = new ArrayList<>();
        }

        System.out.println("Ergebnis: "+sum);

    }

    // Methode zur Analyse einer Zahlenreihe und Generierung des Musters
    private static ArrayList<List<Integer>> analyzeNumberSeries(List<Integer> series) {
        boolean done = false;
        ArrayList<List<Integer>> al = new ArrayList<>();
        while (!done) {

            List<Integer> l = new ArrayList<>();
            for (int i = 1; i < series.size(); i++) {
                int diff = series.get(i) - series.get(i - 1);
                l.add(diff);
            }
            al.add(l);
            series = l;
            l = new ArrayList<>();

            for (int k : series) {
                if (k != 0) {
                    done = false;
                    break;
                }
                done = true;
            }
        }
        return al;
    }
}
