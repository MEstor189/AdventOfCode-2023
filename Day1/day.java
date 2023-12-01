package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day {


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
    
    
    // eightwo = 8wo 
    // aber bei mir eigh2 
    //weil erst aufsteigend geguckt wird und nicht von rechts nach links
    
    
    
    
    public static ArrayList<String> filterNum(List<String> inputList) {     
        ArrayList<String> alNum = new ArrayList<>();
        ArrayList<String> alNumNew = new ArrayList<>();
        for(String line : inputList){
            if (line.contains(line)) {
                
            }
            line= line.replace("one", "1");
            line=line.replace("two", "2");
            line=line.replace("three", "3");
            line=line.replace("four", "4");
            line=line.replace("five", "5");
            line=line.replace("six", "6");
            line=line.replace("seven", "7");
            line=line.replace("eight", "8");
            line=line.replace("nine", "9");
            //System.out.println(line);
            alNumNew.add(line);

        }
        Pattern p = Pattern.compile("[+-]?[0-9]+");
        String s="";
        for (String line : alNumNew) {
            Matcher m = p.matcher(line);
            while ( m.find() ) {
                int a=Integer.parseInt(line.substring(m.start(), m.end()));
                s= s+line.substring(m.start(), m.end()); 	        
    	}
        alNum.add(s);
        s="";
        }   

        //System.out.println(alNum);
        return alNum;
    }

    public static Integer sumAll(ArrayList<String>numArrayList){
        char firstDigit;
        char lastDigit;
        String num;
        int sum=0;
        for (String i : numArrayList) {
            //System.out.println(i);
            if(i.length()>2){
                firstDigit =  i.charAt(0);
                lastDigit = i.charAt(i.length()-1);
                num= ""+firstDigit+lastDigit;
                System.out.println(num);
                sum=sum+ Integer.parseInt(num);
            }else if (i.length()<2) {
                i=i+i;
                System.out.println(i);
                sum=sum+Integer.parseInt(i);
            }else{
                System.out.println(i);
                sum=sum+Integer.parseInt(i);
            }

            //System.out.println(sum);
            
        }

        


        return sum;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/aocD1.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);

        
        filterNum(lines);
        System.out.println(sumAll(filterNum(lines)));
        
    }

}