package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    
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

    public static int aufteilen (String inputstString){
        ArrayList<String[]> aList = new ArrayList<>();
        int counter=0;
        
        String [] teilStrings = inputstString.split("[:|]");
        //System.out.println(teilStrings[0]);


        for (int i = 1; i<=2;i++) {
            String [] teil = teilStrings[i].split(" ");
            
            aList.add(teil);
        }

        String [] a = aList.get(1);
        
        for (String string : aList.get(0)) {

            if(!string.isEmpty()){

            for (String string2 : aList.get(1)) {
                if(string.equals(string2)&& string!=""){
                    counter++;
                }
                
            }
        }
            
            
                
            
            
        }
        System.out.println((int)Math.pow(2, counter-1));

        return (int)Math.pow(2, counter-1);
        
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/d4test.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);
        int num=0;
        for (String string : lines) {
            num = num + aufteilen(string);
        }
        System.out.println(num);
    }


}
