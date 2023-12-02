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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day {
    private static String s;

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
    // test

    // eightwo = 8wo
    // aber bei mir eigh2
    // weil erst aufsteigend geguckt wird und nicht von rechts nach links

    public static ArrayList<String> filterNum(List<String> inputList) {
        ArrayList<String> alNum = new ArrayList<>();
        ArrayList<String> alNumNew = new ArrayList<>();
        // System.out.println(inputList);

        for (String line : inputList) {
            alNumNew.add(convertStringToNumber(line));
            // System.out.println("OO");

        }
        
      /*  Pattern p = Pattern.compile("[+-]?[0-9]+");
        String s = "";
        for (String line : alNumNew) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                int a = Integer.parseInt(line.substring(m.start(), m.end()));
                s = s + line.substring(m.start(), m.end());
            }
            alNum.add(s);
            s = "";
        }
*/
        System.out.println(alNumNew);
        System.out.println(alNumNew.size());
        return alNumNew;
    }


    public static Integer sumAll(ArrayList<String> numArrayList) {
        int counter=0;
        char firstDigit;
        char lastDigit;
        String num;
        String zahlen="";
        int sum = 0;
        for (String i : numArrayList) {
            // System.out.println(i);
            if (i.length() > 2) {
                firstDigit = i.charAt(0);
                lastDigit = i.charAt(i.length() - 1);
                num = "" + firstDigit + lastDigit;
                zahlen= zahlen +"+"+num;
                System.out.println(num);
                counter++;
                sum = sum + Integer.parseInt(num);
            } else if (i.length() < 2) {
                i = i + i;
                zahlen= zahlen +"+"+i;
                 System.out.println(i);
                 counter++;
                sum = sum + Integer.parseInt(i);
            } else if(i.length()==2) {
                zahlen= zahlen +"+"+Integer.parseInt(i);
                 System.out.println(i);
                 counter++;
                sum = sum + Integer.parseInt(i);
                
            }

        }
        System.out.println(counter);
        //System.out.println(zahlen);
        return sum;
    }








    public static void main(String[] args) {
        String filePath = "C:/Users/Siu/Desktop/aoc2023/d1.txt"; // Passe den Pfad entsprechend an
        List<String> lines = readLinesFromFile(filePath);
        // System.out.println("l");
        //filterNum(lines);
        //System.out.println(convertStringToNumber("n6two1brpjhf"));
        System.out.println(sumAll(filterNum(lines)));


    }

    public static String convertStringToNumber(String inputString) {
        List<String> nummern = new ArrayList<String>() {
            {
              add("one");
              add("two");
              add("three");
              add("four");
              add("five");
              add("six");
              add("seven");
              add("eight");
              add("nine");
            }
            
          };
        Map<String, String> wordToNumberMap = new HashMap<>();
        wordToNumberMap.put("one", "1");
        wordToNumberMap.put("two", "2");
        wordToNumberMap.put("three", "3");
        wordToNumberMap.put("four", "4");
        wordToNumberMap.put("five", "5");
        wordToNumberMap.put("six", "6");
        wordToNumberMap.put("seven", "7");
        wordToNumberMap.put("eight", "8");
        wordToNumberMap.put("nine", "9");

        StringBuilder result = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();
        StringBuilder currentWordBuilder = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                String currentWord = currentNumber.toString();
                currentNumber.setLength(0);

                if (!currentWord.isEmpty()) {
                    result.append(currentWord);
                }

                currentWordBuilder.append(c);


                String currentWordString = currentWordBuilder.toString();
                for (String string : nummern) {
                    if(currentWordString.contains(string)){
                        result.append(wordToNumberMap.get(string));
                        currentWordBuilder=new StringBuilder();
                    }
                    
                }

                /*if (wordToNumberMap.containsKey(currentWordString)) {
                    result.append(wordToNumberMap.get(currentWordString));
                    currentWordBuilder= new StringBuilder();
                }
                */
            } else if (Character.isDigit(c)) {
                result.append(c);
            }
        }

        // Füge die letzte Zahl hinzu
        if (currentNumber.length() > 0) {
            result.append(currentNumber);
        }
        //System.out.println(result.toString());
        return result.toString();
    }


}

