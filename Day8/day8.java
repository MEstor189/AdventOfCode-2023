package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day8 {
    public static List<String> readLinesFromFile(String filePath) {
        List<String> lines = null;
        Path path = Paths.get(filePath);
        try {
            lines = Files.readAllLines(path);
            ;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/Siu/Desktop/aoc2023/d8.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);
        ArrayList<String[]> network = new ArrayList<>();
        String start = "AAA";
        String ziel = "ZZZ";
        boolean end = false;
        int counter =0;

        char[] firstline = lines.get(0).toCharArray();
        System.out.println(firstline);

        for (int i = 2; i < lines.size(); i++) {
            String s = lines.get(i).replaceAll("[( )]", "");
            String[] str = s.split("[=,]");
            network.add(str);
        }

        while (!end) {

            for (char c : firstline) {

                for (String [] k : network) {
                    
                    String j = k[0];
                    //System.out.println(j);
                    //System.out.println("Start:"+start);
                    //System.out.println("S"+k[0]);
                    if (c == 'R' && j.equals(start)) {
                        start = k[2];

                        counter++;
                        
                        if (start.equals(ziel)) {
                            end = true;
                            System.out.println("L");
                        }

                        break;

                    } else if (c == 'L' && j.equals(start)) {
                        start = k[1];
                        counter++;
                       
                        if (start.equals(ziel)) {
                            end = true;
                            System.out.println("K");
                        }
                        break;
                    }
                }

            }

        }
        System.out.println(start);
        System.out.println(counter);
    }

}
