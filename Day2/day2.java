package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day2 {

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


    public static ArrayList intoArrayList (List<String> liste){
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        for (String str : liste){
            ArrayList array = new ArrayList<>();
            String[] arrOfStr = str.split("[:,;]");
            for (String  s  : arrOfStr) {
                //System.out.println(s);
            }

            arrayList.add(arrOfStr);
            //System.out.println(arrOfStr);
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    public static String enthaelt (String [] stringarray){

        List<String> farben = new ArrayList<String>() {
            {
              add("red");
              add("blue");
              add("green");  
            }  
          };

        Map<String, String> farbeValueMap = new HashMap<>();
        farbeValueMap.put("blue", "14");
        farbeValueMap.put("red", "12");
        farbeValueMap.put("green", "13");

          for (String str  : stringarray) {
            for (String farbestr : farben) {
                if (str.contains(farbestr)) {
                    String [] test = str.split("\\s+");
                    //System.out.println(test[1]);
                    if(Integer.parseInt(test[1])>Integer.parseInt(farbeValueMap.get(farbestr))){
                        //System.out.println(stringarray[0]);
                        return null;  
                    }                 
                }
            }
          }
        return stringarray[0];
    }
    //12 red cubes, 13 green cubes, and 14 blue cubes
    


    public static void main(String[] args) {
     
        int sum=0;
        String filePath = "C:/Users/Siu/Desktop/aoc2023/d2.txt"; // Passe den Pfad entsprechend an
        List<String> list = readLinesFromFile(filePath);
        ArrayList<String[]> arrayList = intoArrayList(list);

        for (String [] array : arrayList) {
            String game = enthaelt(array);
            //System.out.println(game);
            if(game!=null){

            
            String [] k = game.split("\\s+");
            System.out.println(k[1]);
            sum = sum + Integer.parseInt(k[1]);
            }
        }
        System.out.println(sum);
        

        
        
        
    }
}