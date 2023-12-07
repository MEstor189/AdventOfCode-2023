package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day7 {

    private static Map<String, List<Integer>> datenbank = new HashMap<>();

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

        String filePath = "C:/Users/Siu/Desktop/aoc2023/d7test.txt"; // Passe den Pfad entsprechend an
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

        for (String hand : hands) {
            int rank = 0;
            ArrayList<Integer> o = berechne(hand.toCharArray());
            if (o.contains(5)) {
                // 5s
                rank = 1;
            } else if (o.contains(4)) {
                // 4s
                rank = 2;
            } else if (Collections.frequency(o, 3)>2 ) {
                // fullhouse
                rank = 3;
            }else if(Collections.frequency(o, 3)>0&&!hand.contains("J")){
                rank=3;

            } else if (Collections.frequency(o, 3)<=2&&Collections.frequency(o, 3)>0) {
                // 3s
                rank = 4;
            } else if (o.contains(2) && o.size() == 3) {
                // 2 2s
                rank = 5;
            } else if (o.contains(2) /* && o.size() == 4 */) {
                // 1 2s
                rank = 6;
            } else {
                // 1s
                rank = 7;
            }

            List<Integer> u = (datenbank.get(hand.toString()));
            // values = datenbank.get(hand.toString());
            for (int w : u) {
                // System.out.println("Value: " + w);
            }
            // System.out.println("L: "+datenbank.entrySet());
            // System.out.println("rang: " + rank);
            u.add(rank);

            datenbank.replace(hand.toString(), u);
            // System.out.println(datenbank.entrySet());
        }
        int counter = lines.size();
        long sum = 0;

        List<Map.Entry<String, List<Integer>>> list = new ArrayList<>(datenbank.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            int compareResult = Integer.compare(entry1.getValue().get(1), entry2.getValue().get(1));
            if (compareResult == 0) {
                // Wenn die hintere Zahl gleich ist, vergleiche die vorderen Zahlen
                return compareKeys(entry1.getKey(), entry2.getKey());
            } else {
                return compareResult;
            }
        });

        for (Map.Entry<String, List<Integer>> entry : list) {

            System.out.println(entry.getKey() + " = " + entry.getValue() + " counter: " + counter);
            sum = sum + (entry.getValue().get(0) * counter);
            counter--;

        }
        System.out.println(sum);
    }

    private static int compareKeys(String key1, String key2) {
        String order = "AKQT98765432J";
        for (int i = 0; i < 5; i++) {
            int compareResult = Integer.compare(order.indexOf(key1.charAt(i)), order.indexOf(key2.charAt(i)));
            if (compareResult != 0) {
                return Integer.compare(order.indexOf(key1.charAt(i)), order.indexOf(key2.charAt(i)));
            }
        }
        return 0;
    }

    public static ArrayList<Integer> berechne(char[] line) {
        int o = 0;

        char[] dig = { 'A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2' };
        String chars = "AKQT98765432";
        String lineAsString = new String(line);

        ArrayList<Integer> counter = new ArrayList<>();

        /*for (char c : line) {
            if (c == 'J') {
                o++;
            }
        }
        if (o == 5) {
            counter.add(0);
            return (counter);
        }
*/
        for (char d : dig) {
            int count = 0;
            for (char c : line) {
                boolean gewertet = false;
                if (c == d) {   
                    count++;
                }
                if(lineAsString.contains("J")){
                    count++;
                }
                if(c=='J'){
                    count=0;
                }
                

            }
            if (count != 0) {
                counter.add(count);
            }
        }
        
          System.out.println(line);
          for (int i : counter) {
         System.out.println("UUU: " +i);
          }
         
        return counter;

    }
}
