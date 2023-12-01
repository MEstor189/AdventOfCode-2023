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

    public static ArrayList<Integer> filterNum(List<String> inputList) {
        
        ArrayList<Integer> alNum = new ArrayList<>();
        Pattern p = Pattern.compile("[+-]?[0-9]+");
        String s="";
        for (String line : inputList) {
            Matcher m = p.matcher(line);
            while ( m.find() ) {
                int a=Integer.parseInt(line.substring(m.start(), m.end()));
                s= s+line.substring(m.start(), m.end());
    	        
    	}
        alNum.add(Integer.parseInt(s));
        s="";
        }
        
        System.out.println(alNum);
        return alNum;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/aocD1.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);

        filterNum(lines);
        //System.out.println(filterNum(lines));
        
    }

}