package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day7 {

    private static Map<String, ArrayList<Integer>> datenbank = new HashMap<>();

    public static ArrayList<String> readLines(String filePath) {
        ArrayList<String> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // char[] charArray = line.toCharArray();
                linesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    public static void main(String[] args) {

        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/d7test.txt"; // Passe den Pfad entsprechend an
        ArrayList<String> lines = readLines(filePath);
        ArrayList<String> hands = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        for (String str : lines) {
            String[] arrOfStr = str.split(" ");
            ArrayList<Integer> value = new ArrayList<>();
            value.add(Integer.parseInt(arrOfStr[1]));
            datenbank.put(arrOfStr[0], value);
            hands.add(arrOfStr[0]);

        }

        for (int jk : values) {
            System.out.println("Ppp: " + jk);
        }

        for (String hand : hands) {
            int rank = 0;
            ArrayList<Integer> o = berechne(hand.toCharArray());
            if (o.contains(5)) {
                rank = 1;
            } else if (o.contains(4)) {
                rank = 2;
            } else if (o.contains(3) && o.contains(2)) {
                rank = 3;
            } else if (o.contains(3) && o.contains(1)) {
                rank = 4;
            } else if (o.contains(2) && o.size() == 3) {
                rank = 5;
            } else if (o.contains(2) && o.size() == 4) {
                rank = 6;
            } else {
                rank = 7;
            }

            ArrayList<Integer> u =(datenbank.get(hand.toString()));
            //values = datenbank.get(hand.toString());
            for (int  w  : u) {
                System.out.println("Value: "+ w);
            }
            //System.out.println("L: "+datenbank.entrySet());
            //System.out.println("rang: " + rank);
            u.add(rank);

            datenbank.replace(hand.toString(), u);
            // System.out.println(datenbank.entrySet());
        }

        for (Map.Entry e : datenbank.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

    }

    public static ArrayList<Integer> berechne(char[] line) {

        char[] dig = { 'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2' };

        ArrayList<Integer> counter = new ArrayList<>();
        for (char d : dig) {
            int count = 0;
            for (char c : line) {
                if (c == d) {
                    count++;
                }

            }
            if (count != 0) {
                counter.add(count);
            }
        }

        System.out.println(line);
        for (int i : counter) {
            System.out.println(i);
        }
        return counter;

    }
}
