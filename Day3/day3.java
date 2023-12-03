package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day3 {


    public static ArrayList<char[]> readLines(String filePath) {
        ArrayList<char[]> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] charArray = line.toCharArray();
                linesList.add(charArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    public static void vailid (ArrayList<char[]> lines){
        String num=""; 
        boolean valid = false;
        for(int i=0;i<lines.size();i++){
            System.out.println(lines.get(i));
             char [] line=lines.get(i);
            
            for (int j=0; j< line.length;j++) {
                char c = line[j];
                if(Character.isDigit(c)){
                    
                    valid=adjacent(lines, i, j, valid);
                    num= num + c;
               
                   

                    //System.out.println();
                }else if(num!=""){
                    System.out.println(num + ": " +valid);
                    //System.out.println(num);
                    num = "";
                    valid=false;
                }                
            }            
        } 
    }

    public static boolean adjacent (ArrayList<char[]> lines, int i, int j, boolean valid){
        
        char [] currline = lines.get(i);

        if(j+1<currline.length){

        //rechts
            if(!(currline[j+1]=='.'|| Character.isDigit(currline[j+1]))){
                valid = true;
            }
        }
        if(j-1>=0){   
            if(!(currline[j-1]=='.'|| Character.isDigit(currline[j-1]))){
                System.out.println(currline[j-1]);
                valid = true;   
            }
        }    
        return valid;   // .......421.............#..............+........*....493.......*..........589..................286...............254..........458...672...258
    }

    public static void main(String[] args) {
     
        String filePath = "C:/Users/Siu/Desktop/aoc2023/d3test.txt"; // Passe den Pfad entsprechend an
        ArrayList<char[]> lines = readLines(filePath);
        vailid(lines);

        // Print the content of the ArrayList
        for (char[] line : lines) {
            for (char ch : line) {
               // System.out.print(ch + " ");
            }
           // System.out.println();
        }
    }
}
        

    
        

    

