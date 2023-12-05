package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
    private static int[][] winsCount;

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

    public static int aufteilen(String inputstString) {
        ArrayList<String[]> aList = new ArrayList<>();
        int counter = 0;

        String[] teilStrings = inputstString.split("[:|]");
        // System.out.println(teilStrings[0]);

        for (int i = 1; i <= 2; i++) {
            String[] teil = teilStrings[i].split(" ");

            aList.add(teil);
        }

        String[] a = aList.get(1);

        for (String string : aList.get(0)) {

            if (!string.isEmpty()) {

                for (String string2 : aList.get(1)) {
                    if (string.equals(string2) && string != "") {
                        counter++;
                    }

                }
            }

        }
        // System.out.println(counter);

        return (counter);

    }

    public static int[][] calcScratches(int[][] dArray, int size) {

        for (int i = 0; i < size; i++) {
            for (int l =0; l<size;l++){            }
            int winstemp = dArray[0][i];
            for (int j = 0; j < winstemp; j++) {
                
                int counttemp = dArray[1][i];
                dArray[1][i+j + 1] = dArray[1][i+j+1] + counttemp;
            }            
        }
        return dArray;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/d4.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);
        int scratchAll = 0;
        winsCount = new int[2][lines.size()];
        ArrayList<Integer> wins = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String string = lines.get(i);
            winsCount[0][i] = aufteilen(string);
            winsCount[1][i] = 1;
        }
      /*for (int j = 0; j < lines.size(); j++) {
            System.out.println(winsCount[0][j] + "|" + winsCount[1][j]);
        }
        */
        int[][] arrayScratches = calcScratches(winsCount, lines.size());

        for (int j = 0; j < lines.size(); j++) {
            int num = arrayScratches[1][j];
            scratchAll= scratchAll+num;
        }
        System.out.println(scratchAll);
        
    }

}
